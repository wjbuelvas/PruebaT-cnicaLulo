package task;

import exceptions.StatusCodeFallido;
import lombok.AllArgsConstructor;
import models.Empleado;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.apache.http.HttpStatus;
import questions.ResponseCode;

import java.util.Map;

import static exceptions.StatusCodeFallido.STATUS_CODE_FALLIDO;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.hamcrest.core.IsEqual.equalTo;
import static utils.Enum.EnumVariableSesion.ID_EMPLEADO;
import static utils.Enum.RecursoServicio.CREACION;

@AllArgsConstructor
public class Crear implements Task {
    private final Map<String, String> datosEmpleados;

    public static Crear empleado(Map<String, String> datosEmpleados) {
        return instrumented(Crear.class, datosEmpleados);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Empleado empleado = new Empleado(datosEmpleados.get("nombre"), datosEmpleados.get("salario"), datosEmpleados.get("edad"));
        actor.attemptsTo(Post.to(CREACION.getRecurso())
                .with(request -> request.header("Content-Type", "application/json")
                        .body(empleado).log().all()));
        SerenityRest.lastResponse().statusCode();
        actor.should(seeThat("El codigo de respuesta", ResponseCode.was(), equalTo(HttpStatus.SC_OK))
                .orComplainWith(StatusCodeFallido.class, STATUS_CODE_FALLIDO));
        actor.remember(ID_EMPLEADO.getVariableSesion(),
                SerenityRest.lastResponse().jsonPath().getString("data.id"));
        actor.recall(ID_EMPLEADO.getVariableSesion());
    }
}
