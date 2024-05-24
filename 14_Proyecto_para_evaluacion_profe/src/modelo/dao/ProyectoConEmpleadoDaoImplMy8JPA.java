package modelo.dao;

import java.util.List;

import modelo.entidades.Proyecto;
import modelo.entidades.ProyectoConEmpleado;

public class ProyectoConEmpleadoDaoImplMy8JPA extends AbstractDaoImplMy8Jpa implements ProyectoConEmpleadoDao {

	public ProyectoConEmpleadoDaoImplMy8JPA() {
		super();
	}

	@Override
	public boolean alta(ProyectoConEmpleado obj) {
		try {
			tx.begin();
				em.persist(obj);
			tx.commit();
			return true;
		}catch(Exception e) {
		e.printStackTrace();
			return false;
			
		}
	}

	@Override
	public ProyectoConEmpleado eliminar(Integer clave) {
		try {
			ProyectoConEmpleado proyecto1 = buscarUno(clave);
			if (proyecto1 != null) {
				tx.begin();
					em.remove(proyecto1);
				tx.commit();
				return proyecto1;
			}else
				return null;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ProyectoConEmpleado buscarUno(Integer clave) {
		return em.find(ProyectoConEmpleado.class,clave);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProyectoConEmpleado> buscarTodos() {
			jpql = "select p from Proyecto p";
			query = em.createQuery(jpql);
			return query.getResultList();
	}

	@Override
	public List<ProyectoConEmpleado> empleadosByProyecto(String codigoProyecto) {
		// TODO Auto-generated method stub
		return null;
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
	public double costeActualDeProyecto(String codigoProyecto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double margenActualProyecto(String codigoProyecto) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
