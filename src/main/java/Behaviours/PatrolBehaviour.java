package Behaviours;

import Objects.Cell;
import Objects.EnvironmentConnection;
import Objects.WebEnvironment;
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;

import java.io.IOException;
import java.util.List;

/**
 * Created by Alexsandr0x.
 */
public class PatrolBehaviour extends SimpleBehaviour {
    private static final String API_PATH = "http://localhost/api";

    private EnvironmentConnection env = new WebEnvironment(API_PATH);
    private Cell actualPosition = null;
    public void action() {
        System.out.println("Começo do método");
        try {
            List<Cell> neighboursCells = env.getNeighbours(actualPosition);
        } catch (IOException e) {
            e.printStackTrace();
        }
        block(1000);
    }

    public PatrolBehaviour(Agent agent) throws IOException {
        super(agent);
        actualPosition = env.getRandomLocation();
    }

    public boolean done() {
        return false;
    }
}
