package minhquyen.modals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutsideProcessing {

    private String additionalSpecOption;

    private String originalSortPosition;

    private String packaging;

    private String packagingDate;

    private String spec;

    private String specialInstructions;

    private String specialInstructionsDate;

    private String type;

    private VendorInfo[] vendorInfos;

}
