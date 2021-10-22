package dev.lillian.proxycheck;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import java.net.URL;

public final class ProxyCheckAPI {
    private final ProxyCheckAPISettings i_settings;
    private final ObjectMapper m_mapper = new ObjectMapper();

    public ProxyCheckAPI(@NotNull ProxyCheckAPISettings settings) {
        this.i_settings = settings;
        if (settings.getApiKey() == null || settings.getApiKey().isEmpty()) {
            throw new RuntimeException("Invalid api key!");
        }
    }

    @NotNull
    private String url(@NotNull String ip) {
        assert i_settings.getApiKey() != null;

        StringBuilder url = new StringBuilder("https://proxycheck.io/v2/").append(ip);
        url.append("?key=").append(i_settings.getApiKey());

        if (i_settings.shouldGetVPN()) url.append("&vpn=1");
        if (i_settings.shouldGetASN()) url.append("&asn=1");
        if (i_settings.shouldGetNode()) url.append("&node=1");
        if (i_settings.shouldGetTime()) url.append("&time=1");
        if (i_settings.shouldGetRiskLevel()) url.append("&risk=").append(i_settings.getRiskLevel());
        if (i_settings.shouldGetPort()) url.append("&port=1");
        if (i_settings.shouldGetSeen()) url.append("&seen=1");
        url.append("&days=").append(i_settings.getDays());

        if (i_settings.getTag() != null) url.append("&tag=").append(i_settings.getTag());
        if (i_settings.getVer() != null) url.append("&ver=").append(i_settings.getVer());

        return url.toString();
    }

    @SneakyThrows
    public ProxyCheckResult getResult(@NotNull String ip) {
        String urlString = url(ip);
        URL url = new URL(urlString);

        try {
            JsonNode node = m_mapper.readTree(url);
            if (!node.get("status").asText().equalsIgnoreCase("ok")) {
                throw new RuntimeException("non OK status code! message=" + node.get("message").asText());
            }

            JsonNode ipNode = node.get(ip);
            ProxyCheckResult result = m_mapper.convertValue(ipNode, ProxyCheckResult.class);
            result.m_status = node.get("status").asText();
            if (i_settings.shouldGetNode()) result.m_node = node.get("node").asText();
            if (i_settings.shouldGetTime()) result.m_queryTime = node.get("query time").asText();

            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
