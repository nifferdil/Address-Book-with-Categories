import java.util.HashMap;
import java.util.Random;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("contacts", request.session().attribute("contacts"));
      model.put("template", "templates/contact_form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());



    post("/contacts", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      ArrayList<Contact> contacts = request.session().attribute("contacts");

      if (contacts == null) {
        contacts = new ArrayList<Contact>();
        request.session().attribute("contacts", contacts);
      }

      String fullname = request.queryParams("fullname");
      Contact newContact = new Contact(fullname);
      request.session().attribute("contact", newContact);

      contacts.add(newContact);

      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());



    // post("/tasks", (request, response) -> {
    //   HashMap<String, Object> model = new HashMap<String, Object>();
    //
    //
    //
    //   model.put("template", "templates/success.vtl");
    //   return new ModelAndView(model, layout);
    //  }, new VelocityTemplateEngine());





}//End of main


}
