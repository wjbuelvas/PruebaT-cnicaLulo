package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.es.Dado;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.screenplay.actors.OnStage.*;
import static utils.Enum.RecursoServicio.API_DUMMI;

public class ConfigurarInicial {

    @Before
    public void configurarActor() {
        setTheStage(new OnlineCast());
        theActorCalled("Wilson");
    }

    @Dado("que Wilson desea consumir la api de Dummy")
    public void obtenerApi() {
        theActorInTheSpotlight().whoCan(CallAnApi.at(API_DUMMI.getRecurso()));
    }

}
