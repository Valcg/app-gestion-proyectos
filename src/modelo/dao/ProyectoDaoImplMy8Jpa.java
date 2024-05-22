package modelo.dao;

import java.math.BigDecimal;
import java.util.List;

import modelo.entidades.Proyecto;

public class ProyectoDaoImplMy8Jpa extends AbstractDaoImplMy8Jpa implements ProyectoDao{
	
	public ProyectoDaoImplMy8Jpa() {
		super();};

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
			Proyecto cliente = buscarUno(clave); 
				if (cliente != null) {
					tx.begin(); 
						em.merge(cliente);
					tx.commit();
					return cliente;
					//TRUE
				}	else
					return null;
		}
			catch(Exception e) {
				//TODoo : handle exception
				e.printStackTrace(); // SI NO FALSE
				return null;
		}
	}

	@Override
	public Proyecto buscarUno(String clave) {
		return em.find(Proyecto.class,clave);
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> buscarTodos() {
		 jpql ="select p from Proyecto p ";
		 query = em.createQuery(jpql);// ES QUERY
		 return query.getResultList();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> proyectosByEstado(String estado) {
		 jpql ="select p from Proyecto p where p.estado like :estado "; //p.estado = :estado";
		 query.setParameter("estado", estado);// nombre de parametro Y EL MAS ES PARA CADENA -- CON UNA SOLA CADENA
			return query.getResultList();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> proyectosByCliente(String cif) {
		 jpql ="select p from Proyecto p where p.cliente.cif like : cif "; //p.cliente.cif = :cif"; // QUEREMOS COMPARAR CON CIF--
		 query.setParameter("cif", cif);//-- USAMOS CIF-- nombre de parametro Y EL MAS ES PARA CADENA 
			return query.getResultList();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> proyectosByJefeProyectoAndByEstado(int jefeProyecto, String estado) {
		 jpql ="select p from Proyecto p where p.empleado.idEmpl = :jefeProyecto and p.estado :estado";
		 query.setParameter("jefeProyecto", jefeProyecto);
		 query.setParameter("estado", estado);
			return query.getResultList();	
	}

	@Override
	public Double importesVentaProyectosTerminados() {
		 jpql ="select sum(p.ventaPrevisto) from Proyecto p where p.estado = 'TERMINADO' ";
		 query = em.createQuery(jpql);
			return ((BigDecimal)query.getSingleResult()).doubleValue();
	}

	@Override	// HEMOS PUESTO AVG PARA QUE NOS DEVUELVA SOLO UN PROYECTO PORQUE SI NO , DA ERROR YA QUE HAY MAS DE 1
				// PROYECTO TERMINADO Y AL HACER EL TEST NO FUNCIONA
	public Double margenBrutoProyectosTerminados() { // COSTE REAL - COSTE PREVISTO
		 jpql ="select avg(p.CosteReal - p.costesPrevisto) from Proyecto p where p.estado like 'TERMINADO' ";
		 query = em.createQuery(jpql);
		 return ((BigDecimal)query.getSingleResult()).doubleValue();
	}

	@Override
	public int diasATerminoProyectoActivo(String codigoProyecto) {
		jpql ="select FUNCTION('DATEDIFF', p.fechaFinPrevisto, CURRENT_DATE()) from Proyecto p where p.estado like 'ACTIVO' and .idProyecto = :codigoProyecto";
		query = em.createQuery(jpql);
		query.setParameter("codigoProyecto", codigoProyecto);
		return (int) query.getSingleResult();
	}

}
