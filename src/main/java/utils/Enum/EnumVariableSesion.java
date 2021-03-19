package utils.Enum;

public enum EnumVariableSesion {
    ID_EMPLEADO("Id del usuario");

    private final String variableSesion;

    public String getVariableSesion() {
        return variableSesion;
    }

    EnumVariableSesion(String variableSesion) {
        this.variableSesion = variableSesion;
    }
}
