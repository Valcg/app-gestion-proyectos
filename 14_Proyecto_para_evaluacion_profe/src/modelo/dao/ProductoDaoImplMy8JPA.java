package modelo.dao;

import java.util.List;

import modelo.entidades.Departamento;
import modelo.entidades.Producto;

public class ProductoDaoImplMy8JPA extends AbstractDaoImplMy8Jpa implements ProductoDao{

	public ProductoDaoImplMy8JPA() {
		super();
	}

	@Override
	public boolean alta(Producto obj) {
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
	public Producto eliminar(Integer clave) {
		try {
			Producto producto1 = buscarUno(clave);
			if (producto1 != null) {
				tx.begin();
					em.remove(producto1);
				tx.commit();
				return producto1;
			}else
				return null;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Producto buscarUno(Integer clave) {
		return em.find(Producto.class,clave);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Producto> buscarTodos() {
		jpql = "select p from Producto p";
		query = em.createQuery(jpql);
		return query.getResultList();
	}
	
	
}
