package exceptions;

public class EstadoObtenidoFallido extends AssertionError {

  public static final String ESTADO_FALLIDO = "El Estado obtenido no corresponde al esperado";

  public EstadoObtenidoFallido(String mensajeDeError, Throwable causaDelError){
    super(mensajeDeError, causaDelError);
  }

}
