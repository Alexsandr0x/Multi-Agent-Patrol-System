package Objects;

/**
 * Created by Alexsandr0x.
 */
public class Cell {
    public int phero;
    public int status;

    public Cell(int status, int phero) {
        this.phero = phero;
        this.status = status;
    }

    @Override
    public String toString() {
        return "(" + status + "," + phero + ")";
    }
}
