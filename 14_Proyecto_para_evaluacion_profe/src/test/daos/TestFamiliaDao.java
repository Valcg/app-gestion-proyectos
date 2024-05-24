package test.daos;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8JPA;
import modelo.dao.DepartamentoDaoImplMy8JPA;
import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImplMy8JPA;
import modelo.dao.FamiliaDao;
import modelo.dao.FamiliaDaoImplMy8JPA;
import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8JPA;
import modelo.entidades.Familia;

public class TestFamiliaDao {

	private static ProyectoDao pdao;
	private static ClienteDao cdao;
	private static EmpleadoDao edao;
	private static FamiliaDao fdao;
	
	static {
		pdao = new ProyectoDaoImplMy8JPA();
		cdao = new ClienteDaoImplMy8JPA();
		edao = new EmpleadoDaoImplMy8JPA();
		fdao = new FamiliaDaoImplMy8JPA();
	}
	
	public static void main(String[] args) {
		alta();
		// eliminar();
		// buscarUno();
		// buscarTodos();
	}

	private static void buscarTodos() {
		fdao.buscarTodos().forEach(System.out::println);
		
	}

	private static void buscarUno() {
		System.out.println(fdao.buscarUno(4));		
	}

	private static void eliminar() {
		// TODO Auto-generated method stub
		
	}

	private static void alta() {
		Familia familia1 = new Familia();
		familia1.setDescripcion("Servicios");
		
		Familia familia2 = new Familia();
		familia2.setDescripcion("Ingresos");
		
		Familia familia3 = new Familia();
		familia3.setDescripcion("Recursos");
		
		Familia familia4 = new Familia();
		familia4.setDescripcion("Tecnología");
		
		System.out.println(fdao.alta(familia1));
		// System.out.println(fdao.alta(familia2));
		// System.out.println(fdao.alta(familia3));
		// System.out.println(fdao.alta(familia4));
	}
}
