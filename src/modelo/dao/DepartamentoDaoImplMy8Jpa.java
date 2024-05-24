package modelo.dao;

import java.util.List;
import modelo.entidades.Departamento;

public class DepartamentoDaoImplMy8Jpa  extends AbstractDaoImplMy8Jpa implements DepartamentoDao {

	public DepartamentoDaoImplMy8Jpa() {
	super();
	}
	
	@Override
	public boolean alta(Departamento obj) {
		
		try {
			tx.begin();		//ABRIMOS CONEXION
			em.persist(obj); // INSERTAMOS- persistir significa que añades un obt de manera permanente un OBJETO
			tx.commit();	//CERRAMOS CONEXION
			return true;	// SI SE PERSISTE TRUE
		}catch(Exception e) {
			//TODoo : handle exception
			e.printStackTrace(); // SI NO FALSE,------- SI SE CAPTURA EL ERROR
			return false;
			}
		}

	@Override
	public Departamento eliminar(Integer clave) {
		try {
			Departamento dep = buscarUno(clave); // aqui e llega el campo clave
				if (dep != null) {
					tx.begin(); // que ARRANQUE PRA PODER HACER EL COMIT
						em.remove(dep);// ELIMINAMOS
					tx.commit();
					return dep;
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
	public Departamento buscarUno(Integer clave) {
		// EM tiene un find, de encontrar , PASAMOS LA CLASE QUE QUEREMOS QUE BUSCE, Y LA CLAVE DEL DEPAR
		return em.find(Departamento.class, clave);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Departamento> buscarTodos() {
		 jpql ="select d from Departamento d ";// d ALIAS que le damos 
		 query = em.createQuery(jpql);// ES QUERY, cconsulta PERSONALIZADA, em, tiene metodo CREAR QUERY Y LE PASAMOS EL jpql la consulta personalizada
		 return query.getResultList(); // DEVUELVE UNA LIST
	}

}
