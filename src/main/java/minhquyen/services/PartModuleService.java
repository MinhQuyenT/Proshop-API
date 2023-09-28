package minhquyen.services;

import com.mashape.unirest.http.Unirest;
import minhquyen.helpers.Common;
import minhquyen.helpers.CustomHeaderEnum;
import minhquyen.modals.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import org.springframework.http.HttpStatus;

@Service
public class PartModuleService {
    private  final RestTemplate _restTemplate;
    public PartModuleService(RestTemplate restTemplate){
        _restTemplate = restTemplate;
    }
    public Object GetData(){
//        RestTemplate restTemplate = new RestTemplate();
        Response data = new Response();
//        UriComponents uriComponents = UriComponentsBuilder.fromUriString(Common.DEV.getUrl())
//                .build()
//                .expand("dodo").encode();
//
//        URI uri = uriComponents.toUri();
//        HttpHeaders headers = new HttpHeaders();
//
//        // Tạo HttpHeaders và thêm header vào đó nếu có
//        if(CustomHeaderEnum.X_RAPIDAPI_KEY.getHeaderName() != null){
//            headers.set(CustomHeaderEnum.X_RAPIDAPI_KEY.getHeaderName(), CustomHeaderEnum.X_RAPIDAPI_KEY.getHeaderValue());
//            headers.set(CustomHeaderEnum.X_RAPIDAPI_HOST.getHeaderName(), CustomHeaderEnum.X_RAPIDAPI_HOST.getHeaderValue());
//            // Tạo HttpEntity với HttpHeaders
//            HttpEntity<String> entity = new HttpEntity<>(headers);
//            responseEntity  = restTemplate.exchange(uri, HttpMethod.GET,entity,String.class);
//        }
//        else{
//            HttpEntity<String> entity = new HttpEntity<>(headers);
//            responseEntity  = restTemplate.exchange(uri, HttpMethod.GET,entity,String.class);
//        }
//        return responseEntity.getBody();
        // Thực hiện yêu cầu HTTP GET
        try{
            HttpResponse<JsonNode> jsonResponse = Unirest.get(Common.DEV.getUrl())
                    .header(CustomHeaderEnum.X_RAPIDAPI_KEY.getHeaderName(), CustomHeaderEnum.X_RAPIDAPI_KEY.getHeaderValue())
                    .asJson();
            // Xử lý phản hồi
            int statusCode = jsonResponse.getStatus();
            JsonNode responseBody = jsonResponse.getBody();

            // Tạo một ResponseEntity mới với các giá trị được cập nhật
            ResponseEntity<JsonNode> responseEntity = new ResponseEntity<>(responseBody, HttpStatus.valueOf(statusCode));

            JsonNode responseEntityBody = responseEntity.getBody();
            HttpStatus responseEntityStatus = responseEntity.getStatusCode();
            data.setStatusCode(responseEntityStatus);
            data.setBody(responseEntityBody);
            return data;
        }catch (com.mashape.unirest.http.exceptions.UnirestException e){
            throw new RuntimeException(e);
        }
    }
}