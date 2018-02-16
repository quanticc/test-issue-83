package main;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

    public static void main(String[] args) throws JsonProcessingException {
        DashCastRequest request = new DashCastRequest("http://yandex.ru", true, false, 0);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(request));
    }

    static class DashCastRequest {
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
}
