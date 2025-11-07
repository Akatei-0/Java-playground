import java.util.ArrayList;
import java.util.List;

public class ShapeMaker {

    public List<String> makeRectangle(int width, int height) {
        List<String> rows = new ArrayList<>();
        for (int y = 0; y < height; y++) {
            String row = "";
            for (int x = 0; x < width; x++) {row += "*";}
            rows.add(row);
        }
        return rows;
    }

    public List<String> makeRightTriangle(int height) {
        List<String> rows = new ArrayList<>();
            String row = "";
        for (int y = 0; y < height; y++) {
            row += "*";
            rows.add(row);
        }
        return rows;
    }

    public List<String> makeDiamond(int height) {
        List<String> rows = new ArrayList<>();
        for (int i = 1; i <= height; i++) {rows.add(makeDiamondRow(i, height));} // top
        for (int i = height - 1; i >= 1; i--) {rows.add(makeDiamondRow(i, height));} // bottom
        return rows;
    }

    private String makeDiamondRow(int currentRow, int totalRows) {
        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < totalRows - currentRow; j++) {sb.append(" ");}
        for (int j = 0; j < 2 * currentRow - 1; j++) {sb.append("*");}
        
        return sb.toString();
    }
}
