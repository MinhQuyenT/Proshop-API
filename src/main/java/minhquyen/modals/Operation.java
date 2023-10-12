package minhquyen.modals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Operation {
    private BillOfMaterial[] billOfMaterials;

    private String estOutsideProcessing;

    private  InProcessCheck[] inProcessChecks;

    private String inspection;

    private String operationDescription ;

    private String operationType;

    private String opNumber;

    private OutsideProcessing[] outsideProcessings;

    private WorkCenter workCenter;

}
