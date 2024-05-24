package modelo.dao;

import java.math.BigDecimal;
import java.util.List;
import modelo.entidades.Proyecto;

public class ProyectoDaoImplMy8Jpa extends AbstractDaoImplMy8Jpa implements ProyectoDao{
	
	public ProyectoDaoImplMy8Jpa() {
		super();
		}
	@Override
	public boolean alta(Proyecto obj) {
		
		try {
			tx.begin();//ABRIMOS CONEXION
			em.persist(obj); // INSERTAMOS- persistir significa que añades un obt de manera permanente un OBJETO
			tx.commit();	//CERRAMOS CONEXION
			return true;	// SI SE PERSISTE TRUE
		}catch(Exception e) {
			e.printStackTrace();
			return false;
			}	
		}
	@Override
	public Proyecto eliminar(String clave) {
		try {
			Proyecto proyecto = buscarUno(clave);   // aqui e llega el campo clave
				if (proyecto != null) {
					tx.begin(); // que ARRANQUE PRA PODER HACER EL COMIT
						em.remove(proyecto);// ELIMINAMOS
					tx.commit();
					return proyecto;
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
		// EM tiene un find, de encontrar , PASAMOS LA CLASE QUE QUEREMOS QUE BUSCE, Y LA CLAVE DEL DEPAR
		return em.find(Proyecto.class, clave);
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> buscarTodos() {
		 jpql ="select p from Proyecto p ";// d ALIAS que le damos 
		 query = em.createQuery(jpql);// ES QUERY, cconsulta PERSONALIZADA, em, tiene metodo CREAR QUERY Y LE PASAMOS EL jpql la consulta personalizada
		 return query.getResultList(); // DEVUELVE UNA LIST
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> proyectosByEstado(String estado) {
		 jpql ="select p from Proyecto p where p.estado = :estado "; //p.estado = :estado";
		 query = em.createQuery(jpql);
		 query.setParameter("estado", estado);// nombre de parametro Y EL MAS ES PARA CADENA -- CON UNA SOLA CADENA
			return query.getResultList();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> proyectosByCliente(String cif) {
		 jpql ="select p from Proyecto p where p.cliente.cif = : cif "; //p.cliente.cif = :cif"; // QUEREMOS COMPARAR CON CIF--
		 query = em.createQuery(jpql);
		 query.setParameter("cif", cif);//-- USAMOS CIF-- nombre de parametro Y EL MAS ES PARA CADENA 
			return query.getResultList();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> proyectosByJefeProyectoAndByEstado(int jefeProyecto, String estado) {
		 jpql ="select p from Proyecto p where p.empleado.idEmpl = :jefeProyecto and p.estado = :estado";
		 query = em.createQuery(jpql);
		 
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
		 jpql ="select avg(p.costeReal - p.costesPrevisto) from Proyecto p where p.estado = 'TERMINADO' ";
		 query = em.createQuery(jpql);
		 return ((BigDecimal)query.getSingleResult()).doubleValue();
	}

	@Override
	public int diasATerminoProyectoActivo(String codigoProyecto) {
		jpql ="select FUNCTION('DATEDIFF', p.fechaFinPrevisto, CURRENT_DATE()) from Proyecto p where p.estado = 'ACTIVO' and p.idProyecto = :codigoProyecto";
		query = em.createQuery(jpql);
		query.setParameter("codigoProyecto", codigoProyecto);
		return (int) query.getSingleResult();
	}

}
