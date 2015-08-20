import java.util.HashMap;
import java.util.Random;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      String firstname = request.queryParams("firstname");
      String lastname = request.queryParams("lastname");

      model.put("firstname", request.session().attribute("firstname"));
      model.put("lastname", request.session().attribute("lastname"));

      Contact newContact = new Contact(firstname, lastname);
      model.put("newContact", newContact);

      model.put("template", "templates/contact_form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


  //
  //
  //
  //
  //   // get("/hangman_form", (request, response) -> {
  //   //   HashMap<String, Object> model = new HashMap<String, Object>();
  //   //   String chosenWord = generateWord();
  //   //   model.put("word", request.session().attribute("word");
  //   //   model.put("bob", bob);
  //   //   model.put("template", "templates/hangman_form.vtl");
  //   //   return new ModelAndView(model, layout);
  //   // }, new VelocityTemplateEngine());
  //   //
  //   // post("/hangman", (request, response) -> {
  //   //   HashMap<String, Object> model = new HashMap<String, Object>();
  //   //
  //   //   String gameWord = request.session().attribute("word");
  //   //
  //   //   String dashedGameWord = Hangman.dashWord(gameWord);
  //   //
  //   //   String letterGuessed = request.queryParams("letter");
  //   // }
}//End of main


}
