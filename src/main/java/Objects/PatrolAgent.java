package Objects;


import Behaviours.PatrolBehaviour;
import jade.core.Agent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexsandr0x.
 */
public class PatrolAgent extends Agent{
    private GridMap map;
    private int x, y;

    @Override
    public void setup()
    {
        addBehaviour( new PatrolBehaviour(this) );
    }

//    public PatrolAgent(GridMap map) {
//        this.map = map;
//    }

//    @Override
//    public void setup() {
//        x = (int)(Math.random() * map.getSize());
//        y = (int)(Math.random() * map.getSize());
//    }

//    public void update() {
//        List<Cell> possibleMoves = new ArrayList<Cell>();
//        possibleMoves.add(map.getTileStatus(x, y - 1));
//        possibleMoves.add(map.getTileStatus(x, y + 1));
//        possibleMoves.add(map.getTileStatus(x - 1, y));
//        possibleMoves.add(map.getTileStatus(x + 1, y));
//
//        Cell chosenCell = possibleMoves.get(0);
//        for(Cell c : possibleMoves) {
//            if(c.status == -1)
//                continue;
//            if (chosenCell.phero <= c.phero)
//                chosenCell = c;
//        }
//    }


}
