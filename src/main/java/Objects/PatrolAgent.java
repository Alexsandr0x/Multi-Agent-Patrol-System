package Objects;


import Behaviours.PatrolBehaviour;
import jade.core.Agent;

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

}
