package dev.lillian.proxycheck;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@SuppressWarnings({"FieldCanBeLocal", "unused"})
public final class ProxyCheckAPISettings {
    private String m_apiKey;
    private boolean m_shouldGetVPN;
    private boolean m_shouldGetASN;
    private boolean m_shouldGetNode;
    private boolean m_shouldGetTime;
    private boolean m_shouldGetRiskLevel;
    private int m_riskLevel;
    private boolean m_shouldGetPort;
    private boolean m_shouldGetSeen;
    private int m_days;
    private String m_tag;
    private String m_ver;

    @NotNull
    public static Builder builder() {
        return new Builder();
    }

    @Nullable
    public String getApiKey() {
        return this.m_apiKey;
    }

    public boolean shouldGetVPN() {
        return this.m_shouldGetVPN;
    }

    public boolean shouldGetASN() {
        return this.m_shouldGetASN;
    }

    public boolean shouldGetNode() {
        return this.m_shouldGetNode;
    }

    public boolean shouldGetTime() {
        return this.m_shouldGetTime;
    }

    public boolean shouldGetRiskLevel() {
        return this.m_shouldGetRiskLevel;
    }

    public int getRiskLevel() {
        return this.m_riskLevel;
    }

    public boolean shouldGetPort() {
        return this.m_shouldGetPort;
    }

    public boolean shouldGetSeen() {
        return this.m_shouldGetSeen;
    }

    public int getDays() {
        return this.m_days;
    }

    @Nullable
    public String getTag() {
        return this.m_tag;
    }

    @Nullable
    public String getVer() {
        return this.m_ver;
    }

    public static final class Builder {
        private String apiKey;
        private boolean shouldGetVPN;
        private boolean shouldGetASN;
        private boolean shouldGetNode;
        private boolean shouldGetTime;
        private boolean shouldGetRiskLevel;
        private int riskLevel = 1;
        private boolean shouldGetPort;
        private boolean shouldGetSeen;
        private int days = 7;
        private String tag;
        private String ver;

        Builder() {
        }

        @NotNull
        public ProxyCheckAPISettings.Builder apiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        @NotNull
        public ProxyCheckAPISettings.Builder shouldGetVPN(boolean shouldGetVPN) {
            this.shouldGetVPN = shouldGetVPN;
            return this;
        }

        @NotNull
        public ProxyCheckAPISettings.Builder shouldGetASN(boolean shouldGetASN) {
            this.shouldGetASN = shouldGetASN;
            return this;
        }

        @NotNull
        public ProxyCheckAPISettings.Builder shouldGetNode(boolean shouldGetNode) {
            this.shouldGetNode = shouldGetNode;
            return this;
        }

        @NotNull
        public ProxyCheckAPISettings.Builder shouldGetTime(boolean shouldGetTime) {
            this.shouldGetTime = shouldGetTime;
            return this;
        }

        @NotNull
        public ProxyCheckAPISettings.Builder shouldGetRiskLevel(boolean shouldGetRiskLevel) {
            this.shouldGetRiskLevel = shouldGetRiskLevel;
            return this;
        }

        @NotNull
        public ProxyCheckAPISettings.Builder riskLevel(int riskLevel) {
            if (riskLevel != 1 && riskLevel != 2) {
                riskLevel = 1;
            }

            this.riskLevel = riskLevel;
            return this;
        }

        @NotNull
        public ProxyCheckAPISettings.Builder shouldGetPort(boolean shouldGetPort) {
            this.shouldGetPort = shouldGetPort;
            return this;
        }

        @NotNull
        public ProxyCheckAPISettings.Builder shouldGetSeen(boolean shouldGetSeen) {
            this.shouldGetSeen = shouldGetSeen;
            return this;
        }

        @NotNull
        public ProxyCheckAPISettings.Builder days(int days) {
            this.days = days;
            return this;
        }

        @NotNull
        public ProxyCheckAPISettings.Builder tag(String tag) {
            this.tag = tag;
            return this;
        }

        @NotNull
        public ProxyCheckAPISettings.Builder ver(String ver) {
            this.ver = ver;
            return this;
        }

        @NotNull
        public ProxyCheckAPISettings build() {
            return new ProxyCheckAPISettings(this.apiKey, this.shouldGetVPN, this.shouldGetASN, this.shouldGetNode, this.shouldGetTime, this.shouldGetRiskLevel, this.riskLevel, this.shouldGetPort, this.shouldGetSeen, this.days, this.tag, this.ver);
        }

        @NotNull
        @Override
        public String toString() {
            return "ProxyCheckAPISettings.Builder(apiKey=" + this.apiKey + ", shouldGetVPN=" + this.shouldGetVPN + ", shouldGetASN=" + this.shouldGetASN + ", shouldGetNode=" + this.shouldGetNode + ", shouldGetTime=" + this.shouldGetTime + ", shouldGetRiskLevel=" + this.shouldGetRiskLevel + ", riskLevel=" + this.riskLevel + ", shouldGetPort=" + this.shouldGetPort + ", shouldGetSeen=" + this.shouldGetSeen + ", days=" + this.days + ", tag=" + this.tag + ", ver=" + this.ver + ")";
        }
    }
}
