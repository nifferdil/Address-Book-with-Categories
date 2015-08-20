import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import java.util.ArrayList;


public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Address Book");
  }

  @Test
  public void contactIsDisplayedTest() {
    goTo("http://localhost:4567/");
    fill("#fullname").with("Jane Doe");
    submit(".btn");
    click("a", withText("Go Back"));
    assertThat(pageSource()).contains("Jane Doe");
  }

  @Test
  public void multipleContactsAreDisplayedTest() {
    goTo("http://localhost:4567/");
    fill("#fullname").with("Jane Doe");
    submit(".btn");
    click("a", withText("Go Back"));
    fill("#fullname").with("John Doeh");
    submit(".btn");
    click("a", withText("Go Back"));
    assertThat(pageSource()).contains("Jane Doe");
    assertThat(pageSource()).contains("John Doeh");
  }

  @Test
  public void contactIsCreatedTest() {
    goTo("http://localhost:4567/");
    fill("#fullname").with("Jane Doe");
    submit(".btn");
    assertThat(pageSource()).contains("Your contact has been saved.");
  }
}
