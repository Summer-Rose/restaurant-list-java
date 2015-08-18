import org.fluentlenium.adapter.FluentTest;
import java.util.ArrayList;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.fluentlenium.core.filter.FilterConstructor.*;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegrationTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
  	goTo("http://localhost:4567/");
  	assertThat(pageSource()).contains("Restaurant List");
  }

  @Test
  public void restaurantIsDisplayedTest() {
    goTo("http://localhost:4567/");
    fill("#restaurantName").with("Lardo");
    find("#se").click();
    submit(".btn");
    assertThat(pageSource()).contains("Lardo, SE");
  }

  @Test
  public void multipleRestaurantsAreDisplayedTest() {
    goTo("http://localhost:4567/");
    fill("#restaurantName").with("Lardo");
    find("#se").click();
    submit(".btn");
    fill("#restaurantName").with("People's Pig");
    find("#ne").click();
    submit(".btn");
    assertThat(pageSource()).contains("Lardo, SE");
    assertThat(pageSource()).contains("People's Pig, NE");
  }


}
