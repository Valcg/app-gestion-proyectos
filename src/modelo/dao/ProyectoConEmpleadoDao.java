package modelo.dao;

import java.util.List;

import modelo.entidades.Empleado;
import modelo.entidades.ProyectoConEmpleado;

public interface ProyectoConEmpleadoDao  extends IntGenericoCrud <Integer,ProyectoConEmpleado>{
	
	List<ProyectoConEmpleado>empleadosByProyecto(String codigoProyecto);
	int asignarEmpleadosProyecto(List<ProyectoConEmpleado>empleados); // DAMOS DEALTA UN EMPLEADO DE UN PROYECTO
	int horasAsignadasAProyecto(String codigoProyecto); //Suma de las horas de losempleados asignados al proyecto.


	double costeActualDeProyecto(String codigoProyecto);// . horas*coste-hora de cadaempleado asignado al proyecto.
	double margenActualProyecto(String codigoProyecto); // 

}
