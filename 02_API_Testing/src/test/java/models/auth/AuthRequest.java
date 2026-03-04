package models.auth;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record AuthRequest(
        @JsonProperty("username") String username,
        @JsonProperty("password") String password) {
}
