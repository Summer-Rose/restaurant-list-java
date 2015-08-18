import org.junit.*;
import static org.junit.Assert.*;

public class UnitTest {

	@Test
	public void restaurant_instatiatesCorrectly() {
		Restaurant testRestaurant = new Restaurant("Lardo", "SW");
		assertEquals(true, testRestaurant instanceof Restaurant);
	}

	@Test
	public void restaurant_getsRestaurantName_correctString() {
		Restaurant testRestaurant = new Restaurant("Lardo", "SW");
		assertEquals("Lardo", testRestaurant.getName());
	}

	@Test
	public void restaurant_getsRestaurantQuadrant_correctString() {
		Restaurant testRestaurant = new Restaurant("Lardo", "SW");
		assertEquals("SW", testRestaurant.getQuadrant());
	}
}
