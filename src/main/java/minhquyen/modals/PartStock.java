package minhquyen.modals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartStock {

    public String material;

    public String materialGrade;

    public String partsPerLength;

    public String partStockType;

    public String roughStockHeight;

    public String roughStockLength;

    public String roughStockWidth;

    public String stockRelatedOps;

    public String stockSpec;

    public String widthTolerance;

}
