import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

public class JacksonTest {

    @Test
    public void testSerialization() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        JsonPropertyDashCastRequest jsonPropertyRequest = new JsonPropertyDashCastRequest("http://yandex.ru", true, false, 0);
        DashCastRequest request = new DashCastRequest("http://yandex.ru", true, false, 0);

        String expected = "{\"url\":\"http://yandex.ru\",\"force\":true,\"reload\":false,\"requestId\":null,\"reload_time\":0}";

        Assert.assertEquals(expected, mapper.writeValueAsString(jsonPropertyRequest));
        Assert.assertEquals(expected, mapper.writeValueAsString(request));
    }

    public static class DashCastRequest {
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

    public static class JsonPropertyDashCastRequest {
        @JsonProperty
        final String url;
        @JsonProperty
        final boolean force;
        @JsonProperty
        final boolean reload;
        @JsonProperty("reload_time")
        final int reloadTime;

        private Long requestId;

        public JsonPropertyDashCastRequest(String url,
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
