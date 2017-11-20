package Objects;

import java.util.Comparator;

/**
 * Created by Alexsandr0x.
 */
public class Cell implements Comparable<Cell> {
    public double phero;
    public int x;
    public int y;

    public Cell(int x, int y, double phero) {
        this.phero = phero;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "([" + x + "," + y + "]," + phero + ")";
    }


    public int compareTo(Cell cell) {
        return this.phero < cell.phero ? 1 :
                this.phero > cell.phero ? 1 : 0;
    }
}
