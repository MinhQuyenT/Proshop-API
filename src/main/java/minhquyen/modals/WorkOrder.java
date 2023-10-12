package minhquyen.modals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkOrder {

    private Ops[] ops;

    private Part par;

    private PartStockStatus partStockStatus;

}
