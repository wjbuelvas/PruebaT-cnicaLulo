package stepdefinitions;

import exceptions.EstadoObtenidoFallido;
import exceptions.MensajeObtenidoFallido;
import exceptions.NombreObtenidoFallido;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import questions.Mensaje;
import questions.Nombre;
import questions.Estado;
import task.*;

import java.util.Map;

import static exceptions.EstadoObtenidoFallido.ESTADO_FALLIDO;
import static exceptions.MensajeObtenidoFallido.MENSAJE_FALLIDO;
import static exceptions.NombreObtenidoFallido.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;
import static utils.Enum.EnumVariableSesion.ID_EMPLEADO;


public class GestionEmpleadosDefinitions {

    @Cuando("se crea un empleado con los siguientes datos:")
    public void crearEmpleado(Map<String, String> datosEmpleado) {
        theActorInTheSpotlight().attemptsTo(Crear.empleado(datosEmpleado));
    }

    @Cuando("se consulte un empleado existente en dummy por id {word}")
    public void consultarEmpleado(String idEmpleado) {
        theActorInTheSpotlight().remember(ID_EMPLEADO.getVariableSesion(), idEmpleado);
        theActorInTheSpotlight().attemptsTo(Consultar.empleado());
    }

    @Cuando("se consulte el empleado creado en Dummy")
    public void consultarEmpleadoCreado() {
        theActorInTheSpotlight().attemptsTo(Consultar.empleado());
    }

    @Cuando("se elimine el empleado")
    public void eliminarEmpleadoCreado() {
        theActorInTheSpotlight().attemptsTo(EliminarEmpleado.segunCodigoId());
    }

    @Cuando("se elimine el empleado con id {word}")
    public void eliminarEmpleado(String idEmpleado) {
        theActorInTheSpotlight().remember(ID_EMPLEADO.getVariableSesion(), idEmpleado);
        theActorInTheSpotlight().attemptsTo(EliminarEmpleado.segunCodigoId());
    }

    @Cuando("se actualice el empleado con id {word} con los siguientes datos:")
    public void actualizarEmpleado(String idEmpleado, Map<String, String> datosEmpleado) {
        theActorInTheSpotlight().remember(ID_EMPLEADO.getVariableSesion(), idEmpleado);
        theActorInTheSpotlight().attemptsTo(ActualizarEmpleado.segunCodigoId(datosEmpleado));
    }

    @Cuando("se actualice el empleado creado con los siguientes datos:")
    public void actualizarEmpleadoCreado(Map<String, String> datosEmpleado) {
        theActorInTheSpotlight().attemptsTo(ActualizarEmpleado.segunCodigoId(datosEmpleado));
    }

    @Entonces("el nombre del empleado creado/eliminado/actualizado corresponde a {string}")
    public void validarElNombre(String nombreEmpleado) {
        theActorInTheSpotlight().should(seeThat(Nombre.obtenidoDelResponse(), equalTo(nombreEmpleado))
        .orComplainWith(NombreObtenidoFallido.class, NOMBRE_FALLIDO));
    }

    @Entonces("muestra el mensaje {string}")
    public void validarMensaje(String mensajeRespuesta) {
        theActorInTheSpotlight().should(seeThat(Mensaje.obtenidoDelResponse(), equalTo(mensajeRespuesta))
                .orComplainWith(MensajeObtenidoFallido.class, MENSAJE_FALLIDO));
    }

    @Entonces("la consulta/creación/eliminación/actualización del empleado es correcta obteniendo el estado {word}")
    public void obtenerEstadoConsulta(String estadoConsulta) {
        theActorInTheSpotlight().should(seeThat(Estado.obtenidoDelResponse(), equalTo(estadoConsulta))
                .orComplainWith(EstadoObtenidoFallido.class, ESTADO_FALLIDO));
    }


}
