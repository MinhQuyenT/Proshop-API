package minhquyen.controller;

import io.swagger.annotations.ApiOperation;
import minhquyen.helpers.params.WorkOderParam;
import minhquyen.services.QueryEndpointModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/query-endpoint")
public class QueryEndpointModuleController {

    private final QueryEndpointModuleService _queryEndpointModuleService;

    @Autowired
    public QueryEndpointModuleController(QueryEndpointModuleService queryEndpointModuleService){
        _queryEndpointModuleService = queryEndpointModuleService;
    }

    @GetMapping()
    @ApiOperation("Get Data")
    public Object GetWorkOrder(WorkOderParam workOderParam){
        return _queryEndpointModuleService.GetWorkOrder(workOderParam);
    }
}
