package modelo.dao;

import java.util.List;

import modelo.entidades.Empleado;

public class EmpleadoEnProyectoDaoImplMy8Jpa extends AbstractDaoImplMy8Jpa implements EmpleadosEnProyectoDao {

	public EmpleadoEnProyectoDaoImplMy8Jpa(){
		super();
	}
	@Override
	public boolean alta(Object obj) {
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
	public Object eliminar(Object clave) {
		try {
			Object emp = buscarUno(clave); // aqui e llega el campo clave
				if (emp != null) {
					tx.begin(); // que te va a llegar un insert o varios- INSERTARO MODIFICAR--- EMPIEZA - para hacer el commit
						em.merge(emp);
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
	public Object buscarUno(Object clave) {
		// TODO Auto-generated method stub
		return em.find(Object.class, clave);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> buscarTodos() {
		 jpql ="select e from Empleado e ";
		 query = em.createQuery(jpql);// ES QUERY
		 return query.getResultList();
	}

	@Override
	public List<Empleado> empleadosByProyecto(String codigoProyecto) {
		jpql = "select e from Empleado e where e.apellidos like  : subcadena" ; 
		query = em.createQuery(jpql);//  TIENE UN METODO LLAMADO SETPARAMETER INT--- 

		query.setParameter("cadena", "%"+ codigoProyecto + "%");// nombre de parametro Y EL MAS ES PARA CADENA -- CON UNA SOLA CADENA
		return query.getResultList();
	}

	@Override
	public List<Empleado> asignarEmpleadosAProyecto(String codigoProyecto) {
		// TODO Auto-generated method stub
		return null;
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
