package test.daos;

import java.text.SimpleDateFormat;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8JPA;
import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImplMy8JPA;
import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8JPA;



public class TestProyectoDao {
	
	private static ProyectoDao pdao;
	private static ClienteDao cdao;
	private static EmpleadoDao edao; 
	
	
	static {
		pdao = new ProyectoDaoImplMy8JPA();
		cdao = new ClienteDaoImplMy8JPA();
		edao = new EmpleadoDaoImplMy8JPA();
	}
	
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public static void main(String[] args) {
		alta();
	}

	private static void alta() {
		
	}

}
