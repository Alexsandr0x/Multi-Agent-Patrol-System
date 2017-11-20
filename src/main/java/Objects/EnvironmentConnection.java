package Objects;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

/**
 * Created by Alexsandr0x.
 */
public interface EnvironmentConnection {
    public Cell getRandomLocation() throws IOException;
    public List<Cell> getNeighbours(Cell actualCell) throws IOException;
    public void postPosition(Cell newCell) throws IOException;
}
