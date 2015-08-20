import org.junit.*;
import static org.junit.Assert.*;

public class AddressBookTest {

  @Test
  public void newAddressBook_instantiatesCorrectly() {
    AddressBook testAddressBook = new AddressBook();
    assertEquals(true, testAddressBook instanceof AddressBook);
  }


}
