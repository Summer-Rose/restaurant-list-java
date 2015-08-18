import org.junit.*;
import static org.junit.Assert.*;

public class UnitTest {

	@Test
	public void restaurant_instatiatesCorrectly() {
		Restaurant testRestaurant = new Restaurant("Lardo", "SW");
		assertEquals(true, testRestaurant instanceof Restaurant);
	}

}
