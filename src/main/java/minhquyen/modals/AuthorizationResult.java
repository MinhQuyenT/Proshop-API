package minhquyen.modals;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class AuthorizationResult {
    @JsonProperty("fileAccessSecurityGroup")
    private String fileAccessSecurityGroup;
    @JsonProperty("sessionValidForSeconds")
    private Number sessionValidForSeconds;
    @JsonProperty("sessionValidFrom")
    private String sessionValidFrom;
    @JsonProperty("userName")
    private String userName;
    @JsonProperty("userGroup")
    private String userGroup;
    @JsonProperty("userId")
    private String userId;
    @JsonProperty("token")
    private String token;
}


