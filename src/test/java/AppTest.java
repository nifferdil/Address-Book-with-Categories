import org.fluentlenium.adapter.FluentTest;
import org.junit.Rule;
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

  @Rule
  public ClearRule clearRule = new ClearRule();


  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Address Book");
  }

  @Test
  public void contactIsCreatedTest() {
    goTo("http://localhost:4567/");
    click("a", withText("Add new contact"));
    fill("#description").with("Jane Doe");
    submit(".btn");
    assertThat(pageSource()).contains("Your contact has been saved.");
  }

  @Test
  public void contactIsDisplayedTest() {
    goTo("http://localhost:4567/contacts/new");
    fill("#fullname").with("Jane Doe");
    submit(".btn");
    click("a", withText("View Contacts"));
    assertThat(pageSource()).contains("Jane Doe");
  }

  @Test
  public void multipleContactsAreDisplayedTest() {
    goTo("http://localhost:4567/contact/new");
    fill("#fullname").with("Jane Doe");
    submit(".btn");
    goTo("http://localhost:4567/contacts/new");
    fill("#fullname").with("John Doeh");
    submit(".btn");
    click("a", withText("View Contacts"));
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

  @Test
  public void contactShowPageDisplaysContact() {
    goTo("http://localhost:4567/contacts/new");
    fill("#fullname").with("Jane Doe");
    submit(".btn");
    click("a", withText("View all contacts"));
    click("a", withText("John Doeh"));
    assertThat(pageSource()).contains("Jane Doe");
  }

  @Test
  public void contactNotFoundMessageShown() {
    goTo("http://localhost:4567/contacts/999");
    assertThat(pageSource()).contains("Contact not found");
  }

  @Test
  public void contactShowPageDisplaysDescription() {
    goTo("http://localhost:4567/contacts/new");
    fill("#description").with("John Doeh");
    submit(".btn");
    click("a", withText("View contacts"));
    click("a", withText("John Doeh"));
    assertThat(pageSource()).contains("John Doeh");
  }
}
