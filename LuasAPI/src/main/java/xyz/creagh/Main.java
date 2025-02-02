package xyz.creagh;
import static spark.Spark.port;

public class Main {
  public static void main(String[] args) {
    port(8123);
    WebService luasAPI = new LUASApi();
    luasAPI.init();
  }
}