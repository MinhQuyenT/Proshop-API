package minhquyen.modals;

import com.mashape.unirest.http.JsonNode;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class Response {
    private HttpStatus statusCode;
    private Number statusCode1;
    private Object body;
    private String message;
}
