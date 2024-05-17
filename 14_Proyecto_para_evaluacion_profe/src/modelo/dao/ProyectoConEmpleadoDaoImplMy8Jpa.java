package modelo.dao;

import java.math.BigDecimal;
import java.util.List;

import modelo.entidades.ProyectoConEmpleado;

public class ProyectoConEmpleadoDaoImplMy8Jpa  extends abstractDaoImplMy8Jpa implements ProyectoConEmpleadoDao  {
	
	private static ProyectoDao cdao;
	
	static {
		
		cdao = new ProyectoDaoImplMy8Jpa();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProyectoConEmpleado> empleadosByProyecto(String codigoProyecto) {
		
		jpql="select pe.empleado from ProyectoConEmpleado pe where pe.proyecto.idProyecto = :codigoProyecto";  
		
		query = em.createQuery(jpql);
		
		query.setParameter("codigoProyecto" , codigoProyecto );
		
		return query.getResultList();
	}

	@Override
	public int asignarEmpleadosAProyecto(List<ProyectoConEmpleado> empleados) {
		
		
		
		tx.begin();
		
		// hacemos el for para que cad avez inserte uno nuevo
		
		for (ProyectoConEmpleado proyectoConEmpleado : empleados) {
			
			//recuerdaa que el ++ va de 1 en 1 y asi podemos devolver la cuenta de cuantos se han asignado
			em.persist(proyectoConEmpleado);
		}
		
		tx.commit();
		// el size es un metodo de size y te los cuenta hasta el ultimo que te inserte 
		return empleados.size();
	}

	@Override
	public int horasAsignadasAProyecto(String codigoProyecto) {  // Suma de las horas de los empleados asignados al proyecto
		
		
		jpql="select SUM(pe.horasAsignadas) from ProyectoConEmpleado pe where pe.proyecto.idProyecto = :codigoProyecto";  
		
		query = em.createQuery(jpql);
		
		query.setParameter("codigoProyecto" , codigoProyecto );
		
		return (int) query.getSingleResult();
	}

	@Override
	public double costeActualDeProyecto(String codigoProyecto) { //horas*coste-hora de cada empleado asignado al proyecto.
		
		
		jpql="select SUM(ep.horasAsignadas * ep.empleado.perfil.tasaStandard) from ProyectoConEmpleado ep where ep.proyecto.idProyecto = :codigoProyecto";

		query = em.createQuery(jpql);
		
		query.setParameter("codigoProyecto" , codigoProyecto );
		
		return ((BigDecimal) query.getSingleResult()).doubleValue();
	}

	@Override
	public double margenActualProyecto(String codigoProyecto) { // e. Importe_venta del proyecto = venta prevista – costeActual del Proyecto

		jpql="select ep from ProyectoConEmpleado ep where ep.proyecto.idProyecto = :codigoProyecto";

		query = em.createQuery(jpql);
		
		query.setParameter("codigoProyecto" , codigoProyecto );
		
		return cdao.buscarUno(codigoProyecto).getVentaPrevisto().doubleValue() - costeActualDeProyecto(codigoProyecto);
	}

	@Override
	public boolean alta(ProyectoConEmpleado obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ProyectoConEmpleado eliminar(Integer clave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProyectoConEmpleado buscarUno(Integer clave) {
		return em.find(ProyectoConEmpleado.class, clave);
		
	}

	@Override
	public List<ProyectoConEmpleado> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

	