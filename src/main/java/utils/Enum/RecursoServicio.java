package utils.Enum;

public enum RecursoServicio {
    API_DUMMI("http://dummy.restapiexample.com/api/v1/"),
    ELIMINAR("delete/"),
    ACTUALIZAR("update/"),
    CONSULTAR("employee/"),
    CREACION("create") ;
    private final String recurso;


    RecursoServicio(String recurso) {
        this.recurso = recurso;
    }

    public String getRecurso() {
        return recurso;
    }
    }