package minhquyen.modals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MustBeBackOn {

    private String id;

    private PoItem[] poItems;

    private Supplier supplier;

}
