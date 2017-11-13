package simpleModel;

import Objects.GridMap;
import Objects.PatrolAgent;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;

/**
 * Created by Alexsandr0x.
 */
public class PatrolMain {
    private static final int GRID_SIZE = 30;

    static ContainerController containerController;
    static AgentController agentController;

    public static void main(String[] args) throws InterruptedException  {

        GridMap map = new GridMap(GRID_SIZE);
        PatrolAgent agent = new PatrolAgent(map);
    }
}
