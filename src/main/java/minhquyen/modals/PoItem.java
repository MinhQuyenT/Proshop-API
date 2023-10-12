package minhquyen.modals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PoItem {

    private String costPer;

    private String ots;

    private String extraChargeType;

    private String itemType;

    private String itemNumber;

    private String toolNumber;

    private Number total;

    private String units;

    private String quantity;

}
