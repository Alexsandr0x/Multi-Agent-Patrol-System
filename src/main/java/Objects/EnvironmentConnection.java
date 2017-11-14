package Objects;

import java.util.List;

/**
 * Created by Alexsandr0x.
 */
public interface EnvironmentConnection {
    public Cell getRandomLocation();
    public List<Cell> getNeighbours(Cell actualCell);
    public void postPosition(Cell newCell);
}
