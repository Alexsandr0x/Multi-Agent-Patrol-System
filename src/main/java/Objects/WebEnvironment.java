package Objects;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Alexsandr0x.
 */


public class WebEnvironment implements EnvironmentConnection {

    private String base_url = "localhost/api";
    private Gson gson = new Gson();
    Type type = new TypeToken<Map<String, Object>>(){}.getType();

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
                    ((Double) myMap.get("x")).intValue(),
                    ((Double) myMap.get("y")).intValue(),
                    0);
        }
        input.close();
        System.out.println(actualCell);

        return actualCell;
    }

    public List<Cell> getNeighbours(Cell actualCell) throws IOException {
        int x = actualCell.x;
        int y = actualCell.y;
        URL apiUrl = new URL(base_url + "/neighbours" +
                "?" + "x=" + x + "&" + "y=" + y);
        URLConnection connection = apiUrl.openConnection();
        BufferedReader input = new BufferedReader(
                new InputStreamReader(
                        connection.getInputStream()));

        String inputLine;

        while ((inputLine = input.readLine()) != null) {
            Map<String, Object> myMap = gson.fromJson(inputLine, type);
            List<Cell> neighbours = new ArrayList<Cell>();

            for(Map.Entry<String, Object> entry : myMap.entrySet()) {
                Map<String, Object> neighbourMap = (Map<String, Object>) entry.getValue();
                neighbours.add(new Cell(
                        ((Double) neighbourMap.get("x")).intValue(),
                        ((Double) neighbourMap.get("y")).intValue(),
                        ((Double) neighbourMap.get("phero"))
                ));
            }
            return neighbours;
        }

        return null;
    }

    public void postPosition(Cell newCell) throws IOException {
        int x = newCell.x;
        int y = newCell.y;
        URL apiUrl = new URL(base_url + "/drop_phero" +
                "?" + "x=" + x + "&" + "y=" + y);
        URLConnection connection = apiUrl.openConnection();
        BufferedReader input = new BufferedReader(
                new InputStreamReader(
                        connection.getInputStream()));

        while ((input.readLine()) != null);
    }
}
