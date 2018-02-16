package main;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DashCastRequest {
    final String url;
    final boolean force;
    final boolean reload;
    @JsonProperty("reload_time")
    final int reloadTime;

    private Long requestId;

    public DashCastRequest(String url,
                           boolean force,
                           boolean reload,
                           int reloadTime) {
        this.url = url;
        this.force = force;
        this.reload = reload;
        this.reloadTime = reloadTime;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }
}
