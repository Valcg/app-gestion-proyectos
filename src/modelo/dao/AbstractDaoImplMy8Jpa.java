package modelo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public abstract class AbstractDaoImplMy8Jpa {
	protected EntityManagerFactory emf; // PASARLE EL NOMBRE, lleva los metodos de persistencia y crear obt para las query
	protected EntityManager em; // FUNCION CRUD- ESTA INCORPORADA
	protected EntityTransaction tx;// SE ARARANCA
	protected Query query;// CUANDO HACE FALTA 
	protected String jpql; // CUANDO HACE FALTA,clases y atributos de la instancia -- PONER EL NOMBRE DE LA CLASE
	
	// HACEMOS FACTOR COMUN , CON ALASE ABASTARRCTA
	
	public AbstractDaoImplMy8Jpa() {
		emf = Persistence.createEntityManagerFactory("my_app");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}
	//HEREDAMOS E IMPLEMENTAMOS 

}
