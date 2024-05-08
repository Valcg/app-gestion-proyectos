package modelo.dao;

import java.util.List;
import modelo.entidades.Departamento;

public class DepartamentoDaoImplMy8Jpa  extends abstractDaoImplMy8Jpa 

implements DepartamentoDao {

	@Override
	public boolean alta(Departamento obj) {
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
	public List<Departamento> buscarTodos() {
		jpql = "select d from Departamento d";
		query = em.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public Departamento eliminar(Integer clave) {
		try {
			Departamento dep  = buscarUno(clave);
			if(dep  != null) {
				// que arranque la trnasaccio para poder hacer el commit 
				tx.begin();
					em.remove(dep);
				tx.commit();
				return dep;
			}else {
				return null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Departamento buscarUno(Integer clave) {
		return em.find(Departamento.class, clave);
	}

}
