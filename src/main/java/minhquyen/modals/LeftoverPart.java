package minhquyen.modals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeftoverPart {

    private PurchaseOrderIn purchaseOrderIn;

    private WorkOrderOut workOrderOut;


}
