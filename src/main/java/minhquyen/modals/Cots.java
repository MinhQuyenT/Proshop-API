package minhquyen.modals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cots {
    private String description;

    private LeftoverPart[] leftoverPart;

    private String otsId;
}
