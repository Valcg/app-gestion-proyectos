package modelo.dao;

import java.math.BigDecimal;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> proyectosByEstado(String estado) {

		jpql="select p from Proyecto p where p.estado = :estado";
		
		query = em.createQuery(jpql);
		
		query.setParameter("estado" , estado);
		
		
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> proyectosByCliente(String cif) {
		
		jpql="select p from Proyecto p where p.cliente.cif = :cif";
		
		query = em.createQuery(jpql);
		
		query.setParameter("cif",cif);
		
		
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> proyectosByJefeProyectoAndByEstado(int jefeProyecto, String estado) {
		
		jpql="select p from Proyecto p where p.empleado.idEmpl = :jefeProyecto and p.estado = :estado ";
		//select * from proyectos where estado like "terminado" and jefe_proyecto = 112;
		
		query = em.createQuery(jpql);
		
		query.setParameter("jefeProyecto", jefeProyecto);
		query.setParameter("estado" , estado);
		
		
		return query.getResultList();
	}

	@Override
	public double importesVentaProyectosTerminados() {
		
		jpql="select SUM(p.ventaPrevisto) from Proyecto p where p.estado = 'TERMINADO' ";
		
		query = em.createQuery(jpql);
		
		return ((BigDecimal) query.getSingleResult()).doubleValue();
		
	}

	@Override
	public double margenBrutoProyectosTerminados() {
		jpql="select p.costeReal - p.costesPrevisto from Proyecto p where p.estado like 'terminado' ";
		
		query = em.createQuery(jpql);
		
		return ((BigDecimal)query.getSingleResult()).doubleValue();	
		}
	
	
	//select (coste_real - costes_previsto)  from proyectos  where estado like 'terminado' ;
	//Diferencia suma Importes venta"coste real" y gastos reales.


	@Override
	public int diasATerminoProyectoActivo(String codigoProyecto) {
		
		jpql="select FUNCTION('DATEDIFF', p.fechaFinPrevisto, CURRENT_DATE()) from Proyecto p where p.estado like 'Activo' and p.idProyecto= :codigoProyecto ";
		
		//jpql="select p.datediff(fechaFinPrevisto,CURRENT_DATE()) from Proyecto p where p.estado like 'Activo' and p.idProyecto= :codigoProyecto ";
		
		query = em.createQuery(jpql);
		query.setParameter("codigoProyecto" , codigoProyecto);
		
		return (int) query.getSingleResult();	

		//select *, datediff(fecha_fin_previsto,CURDATE()) as diferencia  from proyectos  where estado like 'Activo';
	}

}
