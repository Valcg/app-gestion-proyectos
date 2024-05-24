package modelo.dao;

import java.math.BigDecimal;
import java.util.List;
import modelo.entidades.Empleado;

public  class EmpleadoDaoImplMy8Jpa  extends AbstractDaoImplMy8Jpa implements EmpleadoDao {
	
	public EmpleadoDaoImplMy8Jpa() {
		super();
		}
	

	@Override
	public boolean alta(Empleado obj) {
		try {
			tx.begin();
			em.persist(obj);
			tx.commit();
			return true;	// SI SE PERSISTE TRUE
		}catch(Exception e) {
			//TODoo : handle exception
			e.printStackTrace(); // SI NO FALSE
			return false;
			}		
	}

	@Override
	public Empleado eliminar(Integer clave) {
		try {
			Empleado emp = buscarUno(clave); // aqui e llega el campo clave
				if (emp != null) {
					tx.begin();  // que ARRANQUE PRA PODER HACER EL COMIT
						em.remove(emp); // ELIMINAMOS
					tx.commit();
					return emp;
					//TRUE
				}	else
					return null;
		}
			catch(Exception e) {
				//TODoo : handle exception
				e.printStackTrace(); // SI NO FALSE
				return null;
		}
	}

	@Override
	public Empleado buscarUno(Integer clave) {
		// EM tiene un find, de encontrar , PASAMOS LA CLASE QUE QUEREMOS QUE BUSCE, Y LA CLAVE DEL DEPAR
		return em.find(Empleado.class, clave);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> empleadosByDepartamento(int idDepar) {
		 jpql ="select e from Empleado e  where e.departamento.idDepar = ?1";//////-------------
			query = em.createQuery(jpql);//  TIENE UN METODO LLAMADO SETPARAMETER INT--- 
			query.setParameter(1, idDepar);
			return query.getResultList(); // DERECHO Y UNCHEQUED PARA QUE NO SALTE 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> empleadosBySexo(String sexo) {
		jpql ="select e from Empleado e where e.genero like = sexo ";
		 query = em.createQuery(jpql);// ES QUERY
		 
		 return query.getResultList();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> empleadosByApellido(String subcadena) {
		
		jpql = "select e from Empleado e where e.apellidos like  : subcadena" ; 
		query = em.createQuery(jpql);//  TIENE UN METODO LLAMADO SETPARAMETER INT--- 

		query.setParameter("cadena", "%"+ subcadena + "%");// nombre de parametro Y EL MAS ES PARA CADENA -- CON UNA SOLA CADENA
		return query.getResultList();// DERECHO Y UNCHEQUED PARA QUE NO SALTE 
	}


	@Override
	public double salarioTotal() {
		
		jpql = "select sum(e.salario) from Empleado e" ; 
		query = em.createQuery(jpql);
		
		return((BigDecimal) query.getSingleResult()).doubleValue();


	}

	@Override //-------------------------------------------------------------------------
	public double salarioTotal(int salario) {
		jpql = "select sum(e.salario) from Empleado e where  e.salario = ?1" ;
		query.setParameter("?1", salario);
		query = em.createQuery(jpql);
	
			return((BigDecimal) query.getSingleResult()).doubleValue();
	}
		
	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> buscarTodos() {
		 jpql ="select e from Empleado e ";
		 query = em.createQuery(jpql);// ES QUERY
		 return query.getResultList();
	}
	
// perfil y departmento dear de alta en el test 
}
