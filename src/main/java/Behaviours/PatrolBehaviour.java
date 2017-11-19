package Behaviours;

import Objects.EnvironmentConnection;
import Objects.WebEnvironment;
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;

import java.io.IOException;

/**
 * Created by Alexsandr0x.
 */
public class PatrolBehaviour extends SimpleBehaviour {
    private static final String API_PATH = "http://localhost/api";

    private EnvironmentConnection env = new WebEnvironment(API_PATH);

    public void action() {
        System.out.println( "Começo do método");
        try {
            env.getRandomLocation();
        } catch (IOException e) {
            e.printStackTrace();
        }
        block(1000);
    }

    public PatrolBehaviour(Agent agent) throws IOException {
        super(agent);
    }

    public boolean done() {
        return false;
    }
}
