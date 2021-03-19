package task;

import exceptions.StatusCodeFallido;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import org.apache.http.HttpStatus;
import questions.ResponseCode;

import static exceptions.StatusCodeFallido.STATUS_CODE_FALLIDO;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.hamcrest.CoreMatchers.equalTo;
import static utils.Enum.EnumVariableSesion.ID_EMPLEADO;
import static utils.Enum.RecursoServicio.CONSULTAR;

public class Consultar implements Task {

    public static Consultar empleado() {
        return instrumented(Consultar.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(CONSULTAR.getRecurso() +actor.recall(ID_EMPLEADO.getVariableSesion())));
        SerenityRest.lastResponse().getBody().prettyPrint();
        actor.should(seeThat("El codigo de respuesta", ResponseCode.was(), equalTo(HttpStatus.SC_OK))
                .orComplainWith(StatusCodeFallido.class, STATUS_CODE_FALLIDO));
    }

}
