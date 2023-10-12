package minhquyen.modals;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;


@Data
public class ResponseEndpoint {

    @JsonProperty("workOrder")
    private WorkOrder workOrder;

    @JsonProperty("part")
    private Part part;

    @JsonProperty("vendorPO")
    private List<VendorPO> vendorPO;

    @JsonProperty("cots")
    private Cots cots;
}
