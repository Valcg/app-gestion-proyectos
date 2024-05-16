package modelo.dao;

import java.util.List;

import modelo.entidades.Producto;

public class ProductoDaoImplMy8Jpa extends abstractDaoImplMy8Jpa implements ProductoDao {

	@Override
	public boolean alta(Producto obj) {
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
	public Producto eliminar(Integer clave) {
		try {
			Producto producto = buscarUno(clave);
			if (producto != null) {
				em.remove(producto);
				return producto;
			}else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	
	}

	@Override
	public Producto buscarUno(Integer clave) {
		return em.find(Producto.class, clave);
		 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Producto> buscarTodos() {
		jpql = "select p from Producto p";
		query = em.createQuery(jpql);
		return query.getResultList();
		
	}

}
