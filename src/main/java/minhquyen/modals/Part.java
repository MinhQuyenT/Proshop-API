package minhquyen.modals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Part {

    private ActivePlanner activePlanner;

    private  String clientPartRev;

    private Company company;

    private String customerPartNumber;

    private DrawingInformation[] drawingInformations;

    private Boolean itarControlled;

    private String  leadTime;

    private String notes;

    private Operation[] operations;

    private String packagingInstructions;

    private String partDescription;

    private String partName;

    private String partNumber;

    private PartStock partStock;

    private String specialShippingInstructions;

    private String status;

    private String year;

}
