import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.Random;
import java.util.ArrayList;

public class Contact {

  private static ArrayList<Contact> contacts = new ArrayList<Contact>();


  private String mFullname;
  private int mId;

  public Contact(String fullname) {
    mFullname = fullname;
    contacts.add(this);
    mId = contacts.size();

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
