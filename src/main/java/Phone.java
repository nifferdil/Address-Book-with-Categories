import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.Random;

public class Phone {
  private String mPhoneNumber;


  public Phone(String phoneNumber) {
    mPhoneNumber = phoneNumber;
  }


  public String getPhoneNumber() {
    return mPhoneNumber;
  }

}
