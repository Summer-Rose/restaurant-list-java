import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;


public class App {
    public static void main(String[] args) {
      ProcessBuilder process = new ProcessBuilder();
       Integer port;
       if (process.environment().get("PORT") != null) {
           port = Integer.parseInt(process.environment().get("PORT"));
       } else {
           port = 4567;
       }

       setPort(port);

    	// staticFileLocation("/public");
    	String layout = "templates/layout.vtl";

      get("/", (request, response) -> {
        HashMap<String, Object> model = new HashMap<String, Object>();


        model.put("template", "templates/index.vtl");
        return new ModelAndView (model, layout);
      }, new VelocityTemplateEngine());

      post("/restaurant-list", (request, response) -> {
        HashMap<String, Object> model = new HashMap<String, Object>();
        // String sessionRestaurant = request.session().attribute("sessionRestaurants");
        // String sessionQuadrant = request.session().attribute("sessionQuadrants")
        // HashMap<String, String> rHashMap = request.session().attribute("rHashMap");

        ArrayList<Restaurant> restaurantList = request.session().attribute("restaurantList");

        if (restaurantList == null) {
          restaurantList = new ArrayList<Restaurant>();
          request.session().attribute("restaurantList", restaurantList);
        }

        String rName = request.queryParams("restaurantName");
        String rQuadrant = (request.queryParams("quadrant")).toUpperCase();
        Restaurant newRestaurant = new Restaurant(rName, rQuadrant);

        restaurantList.add(newRestaurant);

        model.put("restaurantList", request.session().attribute("restaurantList"));

        model.put("template", "templates/index.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());
    }
}
