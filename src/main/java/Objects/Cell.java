package Objects;

/**
 * Created by Alexsandr0x.
 */
public class Cell {
    public int phero;
    public int x;
    public int y;

    public Cell(int x, int y, int phero) {
        this.phero = phero;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "([" + x + "," + y + "]," + phero + ")";
    }
}
