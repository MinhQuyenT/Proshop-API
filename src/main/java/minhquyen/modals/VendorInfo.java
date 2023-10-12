package minhquyen.modals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendorInfo {

    private String daysForFinishing;

    private String daysForFinishingDate;

    private String finishingCostPerPart;

    private String finishingCostPerPartDate;

    private String lotCharge;

    private String quotedby;

}
