package minhquyen.modals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrawingInformation {

    private String drawingNumber;

    private  String latestDrawingRev;

    private String latestPartRev;

    private DrawingRev[] drawingRev;

}
