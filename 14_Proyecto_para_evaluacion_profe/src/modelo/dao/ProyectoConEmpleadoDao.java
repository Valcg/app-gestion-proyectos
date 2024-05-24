package modelo.dao;

import java.util.List;

import modelo.entidades.ProyectoConEmpleado;

public interface ProyectoConEmpleadoDao extends IntGenericoCrud<Integer, ProyectoConEmpleado> {

	List<ProyectoConEmpleado>empleadosByProyecto(String codigoProyecto);
	int asignarEmpleadosAProyecto(List<ProyectoConEmpleado> empleados);
	int horasAsignadasAProyecto(String codigoProyecto);
	public double costeActualDeProyecto(String codigoProyecto);
	public double margenActualProyecto(String codigoProyecto);
}
