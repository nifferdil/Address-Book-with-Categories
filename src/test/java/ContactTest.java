import org.junit.*;
import static org.junit.Assert.*;

public class ContactTest {

@Test
  public void newContact_instantiatesCorrectly() {
    Contact newContact = new Contact("Jane Doe");
    assertEquals("Jane Doe", newContact.getName());
  }
}
