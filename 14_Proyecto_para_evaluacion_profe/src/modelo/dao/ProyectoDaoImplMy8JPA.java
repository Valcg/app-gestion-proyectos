package modelo.dao;

import java.math.BigDecimal;
import java.util.List;

import modelo.entidades.Proyecto;

public class ProyectoDaoImplMy8JPA extends AbstractDaoImplMy8Jpa implements ProyectoDao {

	
	public ProyectoDaoImplMy8JPA() {
		super();
	}

	@Override
	public boolean alta(Proyecto obj) {
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
	public Proyecto eliminar(String clave) {
		try {
			Proyecto proyecto1 = buscarUno(clave);
			if (proyecto1 != null) {
				tx.begin();
					em.remove(proyecto1);
				tx.commit();
				return proyecto1;
			}else
				return null;
			
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
		jpql = "select p from Proyecto p";
		query = em.createQuery(jpql);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> proyectosByEstado(String estado) {
		jpql = "select p Proyecto p"
				+ "where p.estado =:estado";
		query = em.createQuery(jpql);
		query.setParameter("estado", estado);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> proyectosByCliente(String cif) {
		jpql = "select p Proyecto p"
				+ "where p.cliente =:cliente";
		query = em.createQuery(jpql);
		query.setParameter("cliente", cif);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> proyectosByJefeProyectoAndByEstado(int jefeProyecto, String estado) {
		jpql = "select p Proyecto p"
				+ "where p.empleado.idEmpl =:jefeProyecto and p.estado =:estado";
		query = em.createQuery(jpql);
		query.setParameter("jefeProyecto", jefeProyecto);
		query.setParameter("estado", estado);
		return query.getResultList();
	}

	@Override
	public double importesVentaProyectosTerminados() {
		jpql = "select sum(p.ventaPrevisto) from Proyecto where p.estado = 'Terminado'";
		query = em.createQuery(jpql);
		return ((BigDecimal)query.getSingleResult()).doubleValue(); 
	}

	@Override
	public double margenBrutoProyectosTerminados() {
		jpql = "select p.costeReal - p.costesPrevisto from Proyecto where p.estado like 'terminado'";
		query = em.createQuery(jpql);
		return ((BigDecimal)query.getSingleResult()).doubleValue(); 
	}

	@Override
	public int diasATerminoProyectoActivo(String codigoProyecto) {
		jpql = "select FUNCTION('DATEDIFF', p.fechaFinPrevisto, CURRENT_DATE()) from Proyecto p where p.estado like 'Activo' and p.idProyecto= :codigoProyecto";
		
		// mysql = select datediff(current_date(), fecha_fin_previsto) from proyectos where id_proyecto = "FOR2020001";
		
		query = em.createQuery(jpql);
		query.setParameter("codigoProyecto", codigoProyecto);
		return (int) query.getSingleResult();
	}
	
	
	
}
