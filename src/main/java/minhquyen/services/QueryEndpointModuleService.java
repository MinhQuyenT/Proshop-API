package minhquyen.services;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import minhquyen.helpers.Common;
import minhquyen.helpers.params.WorkOderParam;
import minhquyen.modals.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QueryEndpointModuleService {
    private  final RedisService _redisService;
    private  final AuthService _authService;
    public QueryEndpointModuleService(RedisService redisService, AuthService authService){
        _redisService = redisService;
        _authService = authService;

        // Tạo một ObjectMapper và đăng ký nó với Unirest
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Unirest.setObjectMapper(new com.mashape.unirest.http.ObjectMapper() {
            private ObjectMapper jacksonObjectMapper = new ObjectMapper();

            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    return jacksonObjectMapper.readValue(value, valueType);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

            public String writeValue(Object value) {
                try {
                    return jacksonObjectMapper.writeValueAsString(value);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }

    public ResponseEndpoint GetWorkOrder(WorkOderParam workOderParam){

        ResponseEndpoint responseEndpoint = new ResponseEndpoint();
        WorkOrder workOrder = new WorkOrder();
        List<VendorPO> vendorPOs = new ArrayList<>();
        Part part = new Part();
        Cots cots = new Cots();

        String token =  _redisService.getValue("token");
        List<String> partNumbers = workOderParam.getPart();

        Map<String, List<String>> queryParams = new HashMap<>();
        queryParams.put("partNumber", partNumbers);

        //Gọi hàm thực hiện yêu cầu REST API
        try {
            JsonNode jsonResponseWorkOrder =PerformPostRequest(Common.URLENDPOINT.getUrl(), queryParams, token, null);
            ObjectMapper objectMapperWorkOrder = new ObjectMapper();
            workOrder = objectMapperWorkOrder.readValue(jsonResponseWorkOrder.getObject().toString(), WorkOrder.class);

            JsonNode jsonResponsePart = PerformPostRequest(Common.URLENDPOINT.getUrl(), queryParams, token, null);
            ObjectMapper objectMapperPart = new ObjectMapper();
            part = objectMapperPart.readValue(jsonResponsePart.getObject().toString(), Part.class);

            // Get VendorPO
            for (Ops op : workOrder.getOps()) {
                if(op.getMustBeBackOns()!=null){
                    for (MustBeBackOn mustBeBackOn : op.getMustBeBackOns()) {
                        VendorPO  vendorPO =  GetVendorsPO(mustBeBackOn.getId());
                        vendorPOs.add(vendorPO);
                    }
                }
            }

            // Get Cots
            cots = GetCots(part.getPartNumber());

            responseEndpoint.setWorkOrder(workOrder);
            responseEndpoint.setPart(part);
            responseEndpoint.setVendorPO(vendorPOs);
            responseEndpoint.setCots(cots);

            return responseEndpoint;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public VendorPO GetVendorsPO(String id){
        String token =  _redisService.getValue("token");
        VendorPO vendorPO = new VendorPO();
        Map<String, Object> queryParam = new HashMap<>();
        queryParam.put("id", id);

        try {
            JsonNode jsonResponse = PerformPostRequest(Common.URLENDPOINT.getUrl(),null, token, queryParam);
            ObjectMapper objectMapper = new ObjectMapper();
            vendorPO = objectMapper.readValue(jsonResponse.getObject().toString(), VendorPO.class);

            return vendorPO;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Cots GetCots(String part){

        Cots cots = new Cots();
        String token = _redisService.getValue("token");
        Map<String, Object> queryParam = new HashMap<>();
        queryParam.put("part", part);

        try {
            JsonNode jsonResponse = PerformPostRequest(Common.URLENDPOINT.getUrl(),null, token, queryParam);
            ObjectMapper objectMapper = new ObjectMapper();
            cots = objectMapper.readValue(jsonResponse.getObject().toString(), Cots.class);

            return cots;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public JsonNode PerformPostRequest(String url, Map<String, List<String>> queryMaps, String token, Map<String, Object> queryMap) {
        try {

            JsonNode responseBody = new JsonNode("");

            HttpResponse<JsonNode> response = Unirest.post(url)
                    .header("Accept", "application/json")
                    .queryString("token", token)
                    .body(queryMaps != null ? queryMaps : queryMap)
                    .asJson();

            int statusCode = response.getStatus();
            if(response.getBody().toString().contains("token")){
                ResponseObject login =  _authService.Login();
                _redisService.setValue("token",login.getAuthorizationResult().getToken());
                String tokenN = _redisService.getValue("token");
                responseBody = PerformPostRequest(url,queryMaps,tokenN,queryMap);
                return responseBody;
            }
            if(statusCode == 200) {
                 responseBody = response.getBody();
                return responseBody;
            } else {
                throw new UnirestException("Lỗi API: " + statusCode );
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
