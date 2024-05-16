package modelo.dao;

import java.util.List;

import modelo.entidades.Familia;

public class FamiliaDaoImplMy8Jpa extends abstractDaoImplMy8Jpa implements FamiliaDao{

	@Override
	public boolean alta(Familia obj) {
		
		try {
			tx.begin();
			em.persist(obj);
			tx.commit();
			return true;
			
		} catch (Exception e) {
			
			return false;
		}
		
		
	}

	@Override
	public Familia eliminar(Integer clave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Familia buscarUno(Integer clave) {
		
		return em.find(Familia.class, clave);
		
	}

	@Override
	public List<Familia> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
