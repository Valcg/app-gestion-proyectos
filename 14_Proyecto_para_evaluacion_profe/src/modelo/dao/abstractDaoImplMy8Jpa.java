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
	protected Query query; // hace consultas personalizadas
	protected String jpql; // van las sentencias , trabaja con clases y atributos de la clase 
	
	public abstractDaoImplMy8Jpa() {
		emf = Persistence.createEntityManagerFactory("my_app");
		em= emf.createEntityManager();
		tx = em.getTransaction();
		
	}
	
	
	/*EntityManagerFactory emf: Es una interfaz que recolecta los metadatos
	 *  de la unidad de persistencia, es decir, la configuración de la base de datos 
	 *  y las entidades de Java que se van a mapear.
	 

	EntityManager em: Es una interfaz que representa la conexión con la base de datos
	 y contiene métodos para realizar operaciones de CRUD (Create, Read, Update, Delete) en 
	 las entidades.

	EntityTransaction tx: Es una interfaz que se utiliza para manejar las transacciones 
	en la base de datos. Permite iniciar, confirmar o descartar una transacción.

	Query query: Es una interfaz que se utiliza para ejecutar consultas en la base de 
	datos utilizando JPQL (Java Persistence Query Language), un lenguaje de consulta para
	 entidades en JPA.

	String jpql: Es una cadena de texto que contiene las sentencias de consulta en JPQL, 
	que se utilizan para interactuar con las entidades y sus atributos en la base de datos. */
}
