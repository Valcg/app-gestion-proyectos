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

	@Override
	public Empleado eliminar(String clave) {
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
	public Empleado buscarUno(String clave) {
		return em.find(Empleado.class, clave);
		
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

		jpql="select e from Empleado e where e.idDepar = dep";
		query = em.createQuery(jpql);
		
		query.setParameter("dep" , idDepar);
		return query.getResultList();
		
	}
	
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> empleadosBySexo(char sexo) {
		jpql="select e from Empleado e e.genero like :sexo"; // variable host 
		query = em.createQuery(jpql);
		
		query.setParameter("sexo" , sexo);
		return query.getResultList();
		
	}
	
	
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> empleadosByApellido(String subcadena) {
		jpql="select e from Empleado e e.apellidos like :subcadena"; // variable host 
		query = em.createQuery(jpql);
		
		query.setParameter("subcadena" , "%" + subcadena + "%");
		return query.getResultList();
	}

	@Override
	public BigDecimal salarioTotal() {
		jpql=" select sum(e.salario) from Empleado e ";
		query = em.createQuery(jpql);
		
		 BigDecimal totalSalario= (BigDecimal) query.getSingleResult();
		    
		    if (totalSalario != null)
		        return totalSalario;
		    else 
		        return null;
		    }

	@Override
	public BigDecimal salarioTotal(int idDepar) {
		jpql=" select sum(e.salario) from Empleado e where e.idDepar = idDepar";
		query = em.createQuery(jpql);
		
		 BigDecimal totalSalario= (BigDecimal) query.getSingleResult();
		    
		    if (totalSalario != null)
		        return totalSalario;
		    else 
		        return null;
		    }


}
