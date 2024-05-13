package modelo.dao;

import java.util.List;

import modelo.entidades.Cliente;
import modelo.entidades.Empleado;

public class EmpleadoDaoImplMy8JPA extends AbstractDaoImplMy8Jpa implements EmpleadoDao {
	
	public EmpleadoDaoImplMy8JPA() {
		super();
	}
	
	@Override
	public boolean alta(Empleado obj) {
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
	public Empleado eliminar(String clave) {
		try {
			Empleado empleado1 = buscarUno(clave);
			if (empleado1 != null) {
				tx.begin();
					em.remove(empleado1);
				tx.commit();
				return empleado1;
			}else
				return null;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Empleado buscarUno(String clave) {
		return em.find(Empleado.class, clave);
	}

	@Override
	public List<Empleado> buscarTodos() {
		jpql = "select e from Empleado e";
		query = em.createQuery(jpql);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> empleadosByDepartamento(int idDepar) {
		jpql = "select e Empleado e"
				+ "where e.departamento.idDepar =:dep";
		query = em.createQuery(jpql);
		query.setParameter("dep", idDepar);
		return query.getResultList();
	}

	@Override
	public List<Empleado> empleadosBySexo(char sexo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Empleado> empleadosByApellido(String subcadena) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double salarioTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double salarioTotal(int idDepar) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
