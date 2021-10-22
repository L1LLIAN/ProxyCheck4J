package dev.lillian.proxycheck;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

@ToString
public final class ProxyCheckResult {
    String m_status;
    String m_node;
    @JsonProperty("asn")
    String m_asn;
    @JsonProperty("provider")
    String m_provider;
    @JsonProperty("continent")
    String m_continent;
    @JsonProperty("country")
    String m_country;
    @JsonProperty("latitude")
    String m_latitude;
    @JsonProperty("longitude")
    String m_longitude;
    @JsonProperty("isocode")
    String m_isocode;
    @JsonProperty("proxy")
    String m_proxy;
    @JsonProperty("type")
    String m_type;
    @JsonProperty("risk")
    String m_risk;
    String m_queryTime;

    public String getStatus() {
        return m_status;
    }

    public String getNode() {
        return m_node;
    }

    public String getAsn() {
        return m_asn;
    }

    public String getProvider() {
        return m_provider;
    }

    public String getContinent() {
        return m_continent;
    }

    public String getCountry() {
        return m_country;
    }

    public String getLatitude() {
        return m_latitude;
    }

    public String getLongitude() {
        return m_longitude;
    }

    public String getIsocode() {
        return m_isocode;
    }

    public boolean isProxy() {
        return m_proxy.equalsIgnoreCase("yes");
    }

    public String getType() {
        return m_type;
    }

    public int getRisk() {
        if (m_risk != null) {
            return Integer.parseInt(m_risk);
        }

        return -1;
    }

    public String getQueryTime() {
        return m_queryTime;
    }
}
