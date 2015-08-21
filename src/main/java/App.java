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

    get("/contacts", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("contacts", Contact.all());
      model.put("template", "templates/contacts.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    get("contacts/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/contact_form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    get("/contacts/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      Contact contact = Contact.find(Integer.parseInt(request.params(":id")));
      model.put("contact", contact);
      model.put("template", "templates/task.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    post("/contacts", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String fullname = request.queryParams("fullname");
      Contact newContact = new Contact(fullname);
      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());









}//End of main


}
