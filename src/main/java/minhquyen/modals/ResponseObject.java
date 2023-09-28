package minhquyen.modals;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ResponseObject {
    @JsonProperty("authorizationResult")
    private AuthorizationResult authorizationResult;
    @JsonProperty("statusCode")
    private Number statusCode;
    @JsonProperty("warning")
    private String warning;
}
