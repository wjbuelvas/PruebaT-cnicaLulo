package questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class Estado implements Question<String>{


  @Override
  public String answeredBy(Actor actor) {
    return SerenityRest.lastResponse().jsonPath().getString("status")
        .replace("[","").replace("]","");
  }

  public static Estado obtenidoDelResponse() {
    return new Estado();
  }

}
