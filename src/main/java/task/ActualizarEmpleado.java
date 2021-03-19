package task;

import exceptions.StatusCodeFallido;
import lombok.AllArgsConstructor;
import models.Empleado;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;
import org.apache.http.HttpStatus;
import questions.ResponseCode;

import java.util.Map;

import static exceptions.StatusCodeFallido.STATUS_CODE_FALLIDO;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.hamcrest.Matchers.equalTo;
import static utils.Enum.EnumVariableSesion.ID_EMPLEADO;
import static utils.Enum.RecursoServicio.ACTUALIZAR;

@AllArgsConstructor
public class ActualizarEmpleado implements Task {
    private final Map<String, String> datosEmpleado;


    public static ActualizarEmpleado segunCodigoId(Map<String, String> datosEmpleado) {
        return instrumented(ActualizarEmpleado.class, datosEmpleado);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Empleado empleado = new Empleado(datosEmpleado.get("nombre"), datosEmpleado.get("salario"), datosEmpleado.get("edad"));
        actor.attemptsTo(Put.to(ACTUALIZAR.getRecurso() + actor.recall(ID_EMPLEADO.getVariableSesion()))
                .with(request -> request.header("Content-Type", "application/json")
                        .body(empleado).log().all()));
        SerenityRest.lastResponse().body().prettyPrint();
        actor.should(seeThat("El codigo de respuesta", ResponseCode.was(), equalTo(HttpStatus.SC_OK))
                .orComplainWith(StatusCodeFallido.class, STATUS_CODE_FALLIDO));
    }
}
