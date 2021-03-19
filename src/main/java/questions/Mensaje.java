package questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class Mensaje implements Question<String>{


  @Override
  public String answeredBy(Actor actor) {
    return SerenityRest.lastResponse().jsonPath().getString("message")
        .replace("[","").replace("]","");
  }

  public static Mensaje obtenidoDelResponse() {
    return new Mensaje();
  }

}
