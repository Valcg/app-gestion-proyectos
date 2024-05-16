package modelo.dao;


import java.util.List;

import modelo.entidades.ProyectoConProducto;

public class ProyectoConProductoDaoImplMy8Jpa extends abstractDaoImplMy8Jpa implements ProyectoConProductoDao{

	
	
	@Override
	public boolean alta(ProyectoConProducto obj) {
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
	public ProyectoConProducto eliminar(Integer clave) {
		try {
			ProyectoConProducto pp  = buscarUno(clave);
			if(pp  != null) {
				tx.begin();
					em.remove(pp);
				tx.commit();

				return pp;
				
			}else {
				return null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	
	
	}

	@Override
	public ProyectoConProducto buscarUno(Integer clave) {
		em.find(ProyectoConProducto.class, clave);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProyectoConProducto> buscarTodos() {
		jpql = "select p from ProyectoConProducto p";
		query = em.createQuery(jpql);
		return query.getResultList();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProyectoConProducto> productosByProyecto(String codigoProyecto) {

		jpql="select pp.producto from ProyectoConProducto pp where pp.proyecto.idProyecto = :codigoProyecto";  
		
		query = em.createQuery(jpql);
		
		query.setParameter("codigoProyecto" , codigoProyecto );
		
		return query.getResultList();
	}

	
	@Override
	public int asignarProductoAProyecto(List<ProyectoConProducto> productos) {
		
		tx.begin();
		
		for (ProyectoConProducto proyectoConProducto : productos) {
			
			em.persist(proyectoConProducto);
		}
		
		tx.commit();
		return productos.size();
	}

}
