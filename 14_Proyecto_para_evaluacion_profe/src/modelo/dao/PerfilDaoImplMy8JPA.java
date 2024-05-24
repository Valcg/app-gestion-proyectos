package modelo.dao;

import java.util.List;

import modelo.entidades.Departamento;
import modelo.entidades.Perfil;

public class PerfilDaoImplMy8JPA extends AbstractDaoImplMy8Jpa implements PerfilDao{
	
	public PerfilDaoImplMy8JPA() {
		super();
	}

	@Override
	public boolean alta(Perfil obj) {
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
	public Perfil eliminar(Integer clave) {
		try {
			Perfil perfil1 = buscarUno(clave);
			if (perfil1 != null) {
				tx.begin();
					em.remove(perfil1);
				tx.commit();
				return perfil1;
			}else
				return null;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Perfil buscarUno(Integer clave) {
		return em.find(Perfil.class,clave);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Perfil> buscarTodos() {
		jpql = "select p from Perfil p";
		query = em.createQuery(jpql);
		return query.getResultList();
	}
	
	

}
