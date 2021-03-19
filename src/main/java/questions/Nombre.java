package questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class Nombre implements Question<String>{


  @Override
  public String answeredBy(Actor actor) {
    return SerenityRest.lastResponse().jsonPath().getString("data.nombre")
        .replace("[","").replace("]","");
  }

  public static Nombre obtenidoDelResponse() {
    return new Nombre();
  }

}
