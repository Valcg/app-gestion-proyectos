package modelo.dao;

import java.util.List;
import modelo.entidades.Perfil;


public class PerfilDaoImplMy8Jpa  extends AbstractDaoImplMy8Jpa implements PerfilDao {

	@Override
	public boolean alta(Perfil obj) {
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
	public Perfil eliminar(Integer clave) {
		try {
			Perfil emp = buscarUno(clave); // aqui e llega el campo clave
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
	public Perfil buscarUno(Integer clave) {
		// TODO Auto-generated method stub
				return em.find(Perfil.class, clave);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Perfil> buscarTodos() {
		 jpql ="select e from Perfil p ";
		 query = em.createQuery(jpql);// ES QUERY
		 return query.getResultList();
	}

}
