package Behaviours;

import Objects.Cell;
import Objects.EnvironmentConnection;
import Objects.WebEnvironment;
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;

import java.io.IOException;
import java.util.*;

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
            actualPosition = evaporationAlgorithm(neighboursCells);
            System.out.println(actualPosition);
            env.postPosition(actualPosition);
        } catch (IOException e) {
            e.printStackTrace();
        }
        block(200);
    }

    private Cell evaporationAlgorithm(List<Cell> neighbours) {
        for (Cell cell : neighbours) {
            if(cell.phero == -1) {
                cell.phero = Double.MAX_VALUE;
            }
        }
        Collections.sort(neighbours);
        Collections.reverse(neighbours);
        double minimum = Double.MAX_VALUE;
        List<Cell> candidates = new ArrayList<Cell>();
        for(Cell cell : neighbours) {
            if(cell.phero <= minimum) {
                candidates.add(cell);
                minimum = cell.phero;
            }
        }
        if(candidates.size() > 1) {
            return candidates.get((new Random()).nextInt(candidates.size()));
        }
        return candidates.get(0);
    }

    public PatrolBehaviour(Agent agent) throws IOException {
        super(agent);
        actualPosition = env.getRandomLocation();
    }

    public boolean done() {
        return false;
    }
}
