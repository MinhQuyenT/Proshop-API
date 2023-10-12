package minhquyen.modals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {

    private String billToAddress;

    private String billToCity;

    private String billToState;

    private String billToZipcode;

    private String companyName;

    private String phoneNumber;


}
