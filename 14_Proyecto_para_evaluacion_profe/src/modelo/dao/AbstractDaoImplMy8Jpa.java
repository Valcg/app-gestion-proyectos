package modelo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public abstract class AbstractDaoImplMy8Jpa {
	protected EntityManagerFactory emf;
	protected EntityManager em;
	protected EntityTransaction tx;
	protected Query query;
	protected String jpql;
	
	public AbstractDaoImplMy8Jpa() {
		emf = Persistence.createEntityManagerFactory("my_app");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}
	
	

}
