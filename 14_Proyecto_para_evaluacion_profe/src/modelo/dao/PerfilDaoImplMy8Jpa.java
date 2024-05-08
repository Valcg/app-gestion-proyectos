package modelo.dao;

import java.util.List;

import modelo.entidades.Perfil;

public class PerfilDaoImplMy8Jpa extends abstractDaoImplMy8Jpa implements PerfilDao {

	@Override
	public boolean alta(Perfil obj) {
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
	public Perfil eliminar(Integer clave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Perfil buscarUno(Integer clave) {
		return em.find(Perfil.class, clave);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Perfil> buscarTodos() {
		jpql = "select e from Perfil e";
		query = em.createQuery(jpql);
		return query.getResultList();
	}


}
