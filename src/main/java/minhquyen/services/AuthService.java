package minhquyen.services;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import lombok.RequiredArgsConstructor;
import minhquyen.helpers.Common;
import minhquyen.modals.AuthorizationResult;
import minhquyen.modals.Response;
import minhquyen.modals.ResponseObject;
import minhquyen.modals.User;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import org.springframework.http.HttpStatus;

@Service
public class AuthService {

    private final RedisService _redisService;

    @Autowired
    public AuthService( RedisService redisService){
        _redisService = redisService;
    }
    public ResponseObject Login() {
        ResponseObject response = new ResponseObject();
        try {
            // Dữ liệu gửi trong yêu cầu
            JSONObject requestBody = new JSONObject();
            requestBody.put("username", Common.USERNAME.getinfo());
            requestBody.put("password", Common.PASSWORD.getinfo());
            requestBody.put("scope", Common.SCOPE.getinfo());

            // Thực hiện yêu cầu HTTP POST
            HttpResponse<JsonNode> jsonResponse = Unirest.post(Common.LOGIN.getUrl())
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                    .body(requestBody)
                    .asJson();

            // Xử lý phản hồi
            Number statusCode = jsonResponse.getStatus();
            JsonNode responseBody = jsonResponse.getBody();

            ObjectMapper objectMapper = new ObjectMapper();
            response = objectMapper.readValue(responseBody.getObject().toString(), ResponseObject.class);

            _redisService.setValue("token", response.getAuthorizationResult().getToken());
            return response;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
