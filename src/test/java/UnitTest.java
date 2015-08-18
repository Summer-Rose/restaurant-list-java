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

}
