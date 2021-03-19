package exceptions;

public class NombreObtenidoFallido extends AssertionError {

    public static final String NOMBRE_FALLIDO = "El nombre obtenido no corresponde al nombre del empleado esperado";

    public NombreObtenidoFallido(String mensajeDeError, Throwable causaDelError) {
        super(mensajeDeError, causaDelError);
    }

}
