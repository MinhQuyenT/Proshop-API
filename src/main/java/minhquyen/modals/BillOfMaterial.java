package minhquyen.modals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillOfMaterial {

    private String description;

    private String itemNumber;

    private String orderNumber;

    private String quantity;

    private String unit;

}
