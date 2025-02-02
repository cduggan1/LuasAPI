package xyz.creagh;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import static spark.Spark.get;

public class LUASApi extends StopsLoader implements WebService {

  public static void main(String[] args) {
    JsonObject json = loadJson("stops.json");
    if (json == null) {
      return;
    }
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    System.out.println(gson.toJson(json));
  }

  public void init() {
    get("/options", (req, res) -> {
      res.type("application/json");
      return loadJson("stops.json");
    });
  }

}
