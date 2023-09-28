package minhquyen.controller;

import io.swagger.annotations.ApiOperation;
import minhquyen.services.PartModuleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/Part")
public class PartModuleController {
    private final PartModuleService _partModuleService;
    public PartModuleController(PartModuleService partModuleService){
        _partModuleService = partModuleService;
    }

    @GetMapping()
    @ApiOperation("Get Data")
    public Object GetPart(){
        return _partModuleService.GetData();
    }
}
