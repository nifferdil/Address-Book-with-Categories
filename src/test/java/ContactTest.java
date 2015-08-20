import org.junit.*;
import static org.junit.Assert.*;

public class ContactTest {

@Test
  public void newContact_instantiatesCorrectly() {
    Contact testContact = new Contact("Jane", "Doe");
    String firstName = "Jane";
    String lastName = "Doe";
    assertEquals(true, testContact instanceof Contact);
  }
}
