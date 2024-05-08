package modelo.dao;

import java.util.List;


import modelo.entidades.Proyecto;

public class ProyectoDaoImplMy8Jpa extends abstractDaoImplMy8Jpa implements ProyectoDao {
	
	public ProyectoDaoImplMy8Jpa() {
		super();
	}

	@Override
	public boolean alta(Proyecto obj) {
		
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
	public Proyecto eliminar(String clave) {
		try {
			Proyecto proyecto  = buscarUno(clave);
			if(proyecto  != null) {
				// que arranque la trnasaccio para poder hacer el commit 
				tx.begin();
					em.remove(proyecto);
				tx.commit();
				return proyecto;
			}else {
				return null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Proyecto buscarUno(String clave) {
		
		return em.find(Proyecto.class, clave);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> buscarTodos() {
		jpql = "select c from Proyecto c";
		query = em.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public List<Proyecto> proyectosByEstado(String estado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Proyecto> proyectosByCliente(String cif) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Proyecto> proyectosByJefeProyectoAndByEstado(int jefeProyecto, String estado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double importesVentaProyectosTerminados() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double margenBrutoProyectosTerminados() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int diasATerminoProyectoActivo(String codigoProyecto) {
		// TODO Auto-generated method stub
		return 0;
	}

}
