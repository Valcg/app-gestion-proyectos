package modelo.dao;

import java.util.List;
import modelo.entidades.Departamento;


public class DepartamentoDaoImplMy8Jpa  extends AbstractDaoImplMy8Jpa implements DepartamentoDao {

	public DepartamentoDaoImplMy8Jpa() {super();};
	@Override
	public boolean alta(Departamento obj) {
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
	public Departamento eliminar(String clave) {
		try {
			Departamento emp = buscarUno(clave); // aqui e llega el campo clave
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
	public Departamento buscarUno(String clave) {
		// TODO Auto-generated method stub
		return em.find(Departamento.class, clave);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Departamento> buscarTodos() {
		 jpql ="select e from Departamento d ";
		 query = em.createQuery(jpql);// ES QUERY
		 return query.getResultList();
	}

}
