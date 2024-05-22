package modelo.dao;

import java.util.List;

import modelo.entidades.Empleado;



public interface EmpleadosEnProyectoDao extends IntGenericoCrud<Object, Object> {

	List<Empleado> empleadosByProyecto(String codigoProyecto);
	List<Empleado> asignarEmpleadosAProyecto(String codigoProyecto);

	int horasAsignadasAProyecto(String codigoProyecto); //Suma de las horas de losempleados asignados al proyecto.

	double costeActualDeProyecto(String codigoProyecto);// . horas*coste-hora de cadaempleado asignado al proyecto.
	double margenActualProyecto(String codigoProyecto); // Importe_venta del proyecto –costeActual del Proyecto
}
