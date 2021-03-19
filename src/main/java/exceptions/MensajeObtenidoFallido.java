package exceptions;

public class MensajeObtenidoFallido extends AssertionError {

    public static final String MENSAJE_FALLIDO = "El Mensaje obtenido no corresponde al esperado";

    public MensajeObtenidoFallido(String mensajeDeError, Throwable causaDelError) {
        super(mensajeDeError, causaDelError);
    }

}
