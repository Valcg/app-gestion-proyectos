package modelo.dao;

import java.math.BigDecimal;
import java.util.List;
import modelo.entidades.Empleado;

public class EmpleadoDaoImplMy8Jpa extends abstractDaoImplMy8Jpa 

implements EmpleadoDao{
	
	public EmpleadoDaoImplMy8Jpa() {
		super();
	}

	@Override
	public boolean alta(Empleado obj) {
		try {
			tx.begin();
			em.persist(obj);// insert
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();// capturamos el error
			return false;
		}
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> buscarTodos() {
		jpql = "select e from Empleado e";
		query = em.createQuery(jpql);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> empleadosByDepartamento(int idDepar) {

		jpql="select e from Empleado e where e.departamento.idDepar = :idDepar";
		
		query = em.createQuery(jpql);
		
		query.setParameter("idDepar" , idDepar);
		
		
		return query.getResultList();
		
	}
	
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> empleadosBySexo(String sexo) {
		jpql="select e from Empleado e where e.genero like :sexo"; // variable host 
		
		query = em.createQuery(jpql);
		
		query.setParameter("sexo" , sexo);
		
		
		return query.getResultList();
		
	}
	
	
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> empleadosByApellido(String subcadena) {
		jpql="select e from Empleado e where e.apellidos like :subcadena"; // variable host 
		
		query = em.createQuery(jpql);
		query.setParameter("subcadena" , "%" + subcadena + "%");
		
		return query.getResultList();
	}

	@Override
	public double salarioTotal() {
		jpql="select sum(e.salario) from Empleado e";
		query = em.createQuery(jpql);
		
		return ((BigDecimal)query.getSingleResult()).doubleValue();
		    
		 
		    }

	@Override
	public double salarioTotal(int idDepar) {
		jpql=" select sum(e.salario) from Empleado e where e.departamento.idDepar = :id";
		//select sum(e.salario) from empleados e  where e.id_depar = 10;
		query = em.createQuery(jpql);
		query.setParameter("id", idDepar);
		
		
		return ((BigDecimal)query.getSingleResult()).doubleValue();
	    
	   
			}

	@Override
	public Empleado eliminar(Integer clave) {
		try {
			Empleado empleado  = buscarUno(clave);
			if(empleado  != null) {
				// que arranque la trnasaccio para poder hacer el commit 
				tx.begin();
					em.remove(empleado);
				tx.commit();
				return empleado;
			}else {
				return null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Empleado buscarUno(Integer clave) {
		return em.find(Empleado.class, clave);
	}
}
