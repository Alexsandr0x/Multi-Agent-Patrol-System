package Objects;


import Behaviours.PatrolBehaviour;
import jade.core.Agent;

import java.io.IOException;

/**
 * Created by Alexsandr0x.
 */
public class PatrolAgent extends Agent{
    @Override
    public void setup()
    {
        try {
            addBehaviour( new PatrolBehaviour(this) );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
