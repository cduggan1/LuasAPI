package xyz.creagh;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class StopsLoader {
  public static JsonObject loadJson(String fileName) {
    try (InputStream inputStream = LUASApi.class.getClassLoader().getResourceAsStream(fileName)) {
      if (inputStream == null) {
        throw new IllegalArgumentException("File not found: " + fileName);
      }
      InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
      return JsonParser.parseReader(reader).getAsJsonObject();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}
