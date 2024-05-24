package test.daos;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8JPA;
import modelo.dao.DepartamentoDao;
import modelo.dao.DepartamentoDaoImplMy8JPA;
import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImplMy8JPA;
import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8JPA;
import modelo.entidades.Departamento;

public class TestDepartamentoDao {
	
	private static ProyectoDao pdao;
	private static ClienteDao cdao;
	private static EmpleadoDao edao;
	private static DepartamentoDao ddao;
	
	static {
		pdao = new ProyectoDaoImplMy8JPA();
		cdao = new ClienteDaoImplMy8JPA();
		edao = new EmpleadoDaoImplMy8JPA();
		ddao = new DepartamentoDaoImplMy8JPA();
	}
	
	public static void main(String[] args) {
		// alta();
		// eliminar();
		// buscarUno();
		buscarTodos();
	}

	private static void buscarTodos() {
		ddao.buscarTodos().forEach(System.out::println);
		
	}

	private static void buscarUno() {
		System.out.println(ddao.buscarUno(30));
		
	}

	private static void eliminar() {
		System.out.println(ddao.eliminar(50));
		
	}

	private static void alta() {
		Departamento departamento1 = new Departamento();
		departamento1.setNombre("Marketing");
		departamento1.setDireccion("Madrid");
		departamento1.setIdDepar(50);
		
		Departamento departamento2 = new Departamento();
		departamento2.setNombre("Ventas");
		departamento2.setDireccion("Madrid");
		departamento2.setIdDepar(60);
		
		Departamento departamento3 = new Departamento();
		departamento3.setNombre("Recursos Humanos");
		departamento3.setDireccion("Barcelona");
		departamento3.setIdDepar(70);
		
		Departamento departamento4 = new Departamento();
		departamento4.setNombre("Atención al cliente");
		departamento4.setDireccion("Valencia");
		departamento4.setIdDepar(80);
		
		System.out.println(ddao.alta(departamento1));
		// System.out.println(ddao.alta(departamento2));
		// System.out.println(ddao.alta(departamento3));
		// System.out.println(ddao.alta(departamento4));
	}

}
