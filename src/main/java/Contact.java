import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.Random;

public class Contact {
  public static ArrayList<Phone> contacts = new ArrayList<Phone>();
  private String mFirstName;
  private String mLastName;



  public Contact(String firstName, String lastName) {
    mFirstName = firstName;
    mLastName = lastName;
  }


  public String getFirstName() {
    return mFirstName;
  }


  public String getLastName() {
    return mLastName;
  }
  //
  // public String getName() {
  //   String name = "firstname" + "lastname";
  //   return name;
  // }

}
