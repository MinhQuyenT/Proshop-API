package minhquyen.modals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendorPO {

    private PoItem[] poItems;

    private String poType;

    private Supplier supplier;

}
