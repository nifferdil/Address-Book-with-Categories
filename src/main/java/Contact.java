import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.Random;

public class Contact {

  private String mFullname;
  private int mId;

  public Contact(String fullname) {
    mFullname = fullname;

  }

  public String getName() {
    return mFullname;
  }

  public int getId() {
   return mId;
 }

 public static ArrayList<Contact> all() {
     return contacts;
   }

 public static Contact find(int id) {
 try {
   return contacts.get(id - 1);
 } catch (IndexOutOfBoundsException e) {
   return null;
 }
}

public static void clear() {
  contacts.clear();
}

}
