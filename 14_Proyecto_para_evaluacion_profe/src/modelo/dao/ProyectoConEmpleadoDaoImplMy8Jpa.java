package modelo.dao;

import java.util.List;

import modelo.entidades.Proyecto;
import modelo.entidades.ProyectoConEmpleado;

public class ProyectoConEmpleadoDaoImplMy8Jpa  extends abstractDaoImplMy8Jpa implements ProyectoConEmpleadoDao  {

	@SuppressWarnings("unchecked")
	@Override
	public List<ProyectoConEmpleado> empleadosByProyecto(String codigoProyecto) {
		jpql="select c from ProyectoConEmpleado c where c.proyecto.idProyecto = :codigoProyecto";  
		
		query = em.createQuery(jpql);
		
		query.setParameter("codigoProyecto" , codigoProyecto );
		
		return query.getResultList();
	}

	@Override
	public int asignarEmpleadosAProyecto(List<ProyectoConEmpleado> empleados) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int horasAsignadasAProyecto(String codigoProyecto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double costeActualDeProyecto(String codigoProyecto) { //horas*coste-hora de cada empleado asignado al proyecto.
		
		//jpql="select c.(horasAsignadas*empleado.perfil.TasaStandard) from ProyectoConEmpleado c where c.proyecto.idProyecto = :codigoProyecto";  
		jpql = "SELECT c.horasAsignadas * e.perfil.tasaStandard " +
			       "FROM ProyectoConEmpleado c " +
			       "JOIN c.empleado e " +
			       "WHERE c.proyecto.idProyecto = :codigoProyecto";

		query = em.createQuery(jpql);
		
		query.setParameter("codigoProyecto" , codigoProyecto );
		
		return (double) query.getSingleResult();
	}

	@Override
	public double margenActualProyecto(String codigoProyecto) { // e. Importe_venta del proyecto –costeActual del Proyecto

		// TODO Auto-generated method stub
		return 0;
	}
	
}

	