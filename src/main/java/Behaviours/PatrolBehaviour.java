package Behaviours;

import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;

/**
 * Created by Alexsandr0x.
 */
public class PatrolBehaviour extends SimpleBehaviour {

    public void action() {
        System.out.println( "Começo do método");
        block(1000);
    }

    public PatrolBehaviour(Agent agent) {
        super(agent);
    }

    public boolean done() {
        return false;
    }
}
