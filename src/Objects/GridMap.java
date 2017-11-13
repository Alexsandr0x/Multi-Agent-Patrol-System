package Objects;

/**
 * Created by Alexsandr0x.
 */
public class GridMap {
    private static Cell[][] map = null;
    private int size = -1;

    public int getSize(){
        return size;
    }

    public GridMap(int size) {
        this.size = size;

        map = new Cell[size][size];

        for(int x=0; x < size; x++) {
            for(int y=0; y < size; y++) {
                map[x][y] = new Cell(0, 0);
            }
        }
    }

    public Cell getTileStatus(int xPos, int yPos) {
        return map[xPos][yPos];
    }

    public synchronized void setTilePhero(int xPos, int yPos, int phero_modifier) {
        map[xPos][yPos].phero += phero_modifier;
    }

    public void evaporation() {
        for(int x=0; x < size; x++) {
            for(int y=0; y < size; y++) {
                setTilePhero(x, y, -1);
            }
        }
    }

}
