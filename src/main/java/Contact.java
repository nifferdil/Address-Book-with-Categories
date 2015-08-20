import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.Random;

public class Contact {
  //public static ArrayList<Phone> contacts = new ArrayList<Phone>();
  private String mFullname;

  public Contact(String fullname) {
    mFullname = fullname;

  }

  public String getName() {
    return mFullname;
  }




}
