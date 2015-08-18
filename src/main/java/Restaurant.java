public class Restaurant {
  private String mRestaurantName;
  private String mQuadrant;

  public Restaurant(String restaurantName, String quadrant) {
    mRestaurantName = restaurantName;
    mQuadrant = quadrant;
  }

  public String getName() {
    return mRestaurantName;
  }

  public String getQuadrant() {
    return mQuadrant;
  }
}
