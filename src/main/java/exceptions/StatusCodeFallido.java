package exceptions;

public class StatusCodeFallido extends AssertionError {

  public static final String STATUS_CODE_FALLIDO = "El status code obtenido no corresponde al esperado por intermitencia del servicio";

  public StatusCodeFallido(String mensajeDeError, Throwable causaDelError){
    super(mensajeDeError, causaDelError);
  }

}
