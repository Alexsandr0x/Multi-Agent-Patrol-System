package Objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexsandr0x.
 */
public class PatrolAgent {
    private GridMap map;
    private int x, y;

    public PatrolAgent(GridMap map) {
        this.map = map;
    }

    public void setup() {
        x = (int)(Math.random() * map.getSize());
        y = (int)(Math.random() * map.getSize());
    }

    public void update() {
        List<Cell> possibleMoves = new ArrayList<>();
        possibleMoves.add(map.getTileStatus(x, y - 1));
        possibleMoves.add(map.getTileStatus(x, y + 1));
        possibleMoves.add(map.getTileStatus(x - 1, y));
        possibleMoves.add(map.getTileStatus(x + 1, y));

        Cell chosenCell = possibleMoves.get(0);
        for(Cell c : possibleMoves) {
            if(c.status == -1)
                continue;
            if (chosenCell.phero <= c.phero)
                chosenCell = c;     
        }
    }


}
