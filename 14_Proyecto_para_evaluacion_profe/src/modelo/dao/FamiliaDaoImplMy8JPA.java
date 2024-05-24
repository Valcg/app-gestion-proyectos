package modelo.dao;

import java.util.List;

import modelo.entidades.Departamento;
import modelo.entidades.Familia;

public class FamiliaDaoImplMy8JPA extends AbstractDaoImplMy8Jpa implements FamiliaDao{
	
	public FamiliaDaoImplMy8JPA() {
		super();
	}

	@Override
	public boolean alta(Familia obj) {
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
	public Familia eliminar(Integer clave) {
		try {
			Familia familia1 = buscarUno(clave);
			if (familia1 != null) {
				tx.begin();
					em.remove(familia1);
				tx.commit();
				return familia1;
			}else
				return null;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Familia buscarUno(Integer clave) {
		return em.find(Familia.class,clave);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Familia> buscarTodos() {
		jpql = "select f from Familia f";
		query = em.createQuery(jpql);
		return query.getResultList();
	}

}
