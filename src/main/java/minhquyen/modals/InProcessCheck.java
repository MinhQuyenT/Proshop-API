package minhquyen.modals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InProcessCheck {

    private String characterDesignation;

    private String dimTagNumber;

    private String drawingSpec;

    private String inspectfreq;

    private String inspectionEquipment;

    private String nominalDim;

    private String originalSortPosition;

    private String requireipc;

    private String showDimWhen;

    private String specUnit1;

    private String specUnit2;

    private String specUnit3;

    private String tolerance;

}
