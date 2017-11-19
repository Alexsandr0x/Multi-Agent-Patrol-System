package Objects;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * Created by Alexsandr0x.
 */


public class WebEnvironment implements EnvironmentConnection {

    private String base_url = "localhost/api";
    private Gson gson = new Gson();
    Type type = new TypeToken<Map<String, String>>(){}.getType();

    public WebEnvironment(String url) throws IOException {
        super();
        base_url = url;
    }

    public Cell getRandomLocation() throws IOException {
        URL apiUrl = new URL(base_url + "/random_location");
        URLConnection connection = apiUrl.openConnection();
        BufferedReader input = new BufferedReader(
                new InputStreamReader(
                        connection.getInputStream()));

        String inputLine;
        Cell actualCell = null;
        while ((inputLine = input.readLine()) != null){
            Map<String, Object> myMap = gson.fromJson(inputLine, type);
            actualCell = new Cell(
                    Integer.parseInt((String) myMap.get("x")),
                    Integer.parseInt((String) myMap.get("y")),
                    0);
        }
        input.close();
        System.out.println(actualCell);

        return actualCell;
    }

    public List<Cell> getNeighbours(Cell actualCell) {
        return null;
    }

    public void postPosition(Cell newCell) {

    }
}
