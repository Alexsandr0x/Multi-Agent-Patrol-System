package simpleModel;

import Objects.GridMap;
import Objects.PatrolAgent;

/**
 * Created by Alexsandr0x.
 */
public class PatrolMain {
    private static final int GRID_SIZE = 30;

    public static void main(String[] args) {

        GridMap map = new GridMap(GRID_SIZE);
        PatrolAgent agent = new PatrolAgent(map);
    }
}
