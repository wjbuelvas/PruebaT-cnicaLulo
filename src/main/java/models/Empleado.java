package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class Empleado implements Serializable {

    private String nombre;
    private String salario;
    private String edad;
    private final static long serialVersionUID = 5845439126050419655L;

}
