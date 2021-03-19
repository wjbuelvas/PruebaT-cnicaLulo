#language: es
#Autor: Wilson Buelvas Dumar

Característica: test
  Yo como usuario
  deseo realizar la gestión de los empleados en Dummy
  para validar la creación, consulta, actualización y eliminación de empleados

  Antecedentes:
    Dado que Wilson desea consumir la api de Dummy

  Escenario: : Crear empleado en Dummy
    Cuando se crea un empleado con los siguientes datos:
      | nombre  | Wilson Buelvas |
      | salario | 350000         |
      | edad    | 25             |
    Entonces la creación del empleado es correcta obteniendo el estado success
    Y el nombre del empleado creado corresponde a 'Wilson Buelvas'


  Escenario: : Consultar empleado en Dummy
    Cuando se consulte un empleado existente en dummy por id 1
    Entonces la consulta del empleado es correcta obteniendo el estado success
    Y muestra el mensaje 'Successfully! Record has been fetched.'

  Esquema del escenario: : Eliminar empleado en Dummy
    Cuando se elimine el empleado con id <idEmpleado>
    Entonces la eliminación del empleado es correcta obteniendo el estado <estado>
    Y muestra el mensaje '<mensajeRespuesta>'
    Ejemplos:
      | idEmpleado | estado  | mensajeRespuesta                                                |
      | 5          | success | Successfully! Record has been deleted                           |
      | 3          | success | Successfully! Record has been deleted                           |


  Escenario: : Actualizar empleado en Dummy
    Cuando se actualice el empleado con id 5 con los siguientes datos:
      | nombre  | Wilson Javier |
      | salario | 350000        |
      | edad    | 25            |
    Entonces la actualización del empleado es correcta obteniendo el estado success
    Y el nombre del empleado actualizado corresponde a 'Wilson Javier'


  Escenario: Escenario Transversal Creación, consulta, Actualización y eliminación del Empleado
    Cuando se crea un empleado con los siguientes datos:
      | nombre  | Wilson Javier |
      | salario | 350000        |
      | edad    | 25            |
    Y se consulte el empleado creado en Dummy
    Y se actualice el empleado creado con los siguientes datos:
      | nombre  | Wilson Buelvas |
      | salario | 250000         |
      | edad    | 31             |
    Y se elimine el empleado
    Entonces muestra el mensaje 'Successfully! Record has been deleted'
    Y la eliminación del empleado es correcta obteniendo el estado success

