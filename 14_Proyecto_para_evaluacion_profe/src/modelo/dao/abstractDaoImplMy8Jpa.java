package modelo.dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public  abstract  class abstractDaoImplMy8Jpa {

	protected EntityManagerFactory emf; // recoje los metadatos de la unidad de persistencia 
	protected EntityManager em; // tiene incooporadas la funcion crud 
	protected EntityTransaction tx; // arranca la transaccion 
	protected Query query; // 
	protected String jpql; // van las sentencias , trabaja con clases y atributos de la clase 
	
	public abstractDaoImplMy8Jpa() {
		emf = Persistence.createEntityManagerFactory("my_app");
		em= emf.createEntityManager();
		tx = em.getTransaction();
		
	}
	
	
}
