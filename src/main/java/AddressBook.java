import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.Random;
import java.util.ArrayList;

public class AddressBook {
  private ArrayList<Contact> mContacts;


  public AddressBook() {
    mContacts = new ArrayList<Contact>();
  }


}
