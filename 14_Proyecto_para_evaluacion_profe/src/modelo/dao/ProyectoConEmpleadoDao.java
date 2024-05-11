package modelo.dao;

import java.util.List;

import modelo.entidades.ProyectoConEmpleado;

public interface ProyectoConEmpleadoDao  {
	
	List<ProyectoConEmpleado>empleadosByProyecto(String codigoProyecto);
	int asignarEmpleadosAProyecto(List<ProyectoConEmpleado> empleados);
	int horasAsignadasAProyecto(String codigoProyecto); //Suma de las horas de los empleados asignados al proyecto.
	double costeActualDeProyecto(String codigoProyecto);// horas*coste-hora de cada empleado asignado al proyecto.
	double margenActualProyecto(String codigoProyecto); //Importe_venta del proyecto –costeActual del Proyecto

}
