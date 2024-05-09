package test.dao;

import java.math.BigDecimal;

import modelo.dao.DepartamentoDao;
import modelo.dao.DepartamentoDaoImplMy8Jpa;
import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImplMy8Jpa;
import modelo.dao.PerfilDao;
import modelo.dao.PerfilDaoImplMy8Jpa;
import modelo.entidades.Empleado;


public class TestEmpleadoDao {

private static EmpleadoDao edao ;
private static PerfilDao pdao ;
private static DepartamentoDao ddao ;
	
	
	static {
		
		edao = new EmpleadoDaoImplMy8Jpa();
		pdao = new PerfilDaoImplMy8Jpa();
		ddao = new DepartamentoDaoImplMy8Jpa();
}
	
	
	
	public static void main(String[] args) {
		//todos();
		//uno();
		//eliminar();
		//empleadosByDepartamento();
		//empleadosBySexo();
		//empleadosByApellido();
		//salarioTotal();
		salarioTotalINT();
		//alta();
}
	
	public static void alta() {
		
		Empleado empl = new Empleado();
		empl.setNombre("petra");
		empl.setApellidos("pera");
		empl.setGenero("M");
		empl.setFechaIngreso(null);
		empl.setFechaNacimiento(null);
		empl.setEmail("petra@fp.com");
		empl.setPassword("petra");
		empl.setSalario(BigDecimal.valueOf(3000));
		empl.setPerfil(pdao.buscarUno(4));
		empl.setDepartamento(ddao.buscarUno(10));
		empl.setProyectos(null);
			
		 
		System.out.println(edao.alta(empl));
		//todos();
		
		
	}
	
	public static void eliminar() {
		
		Empleado empl = new Empleado();
		empl.setNombre("petra");
		empl.setApellidos("pera");
		empl.setGenero("M");
		empl.setPassword("root");
		empl.setSalario(BigDecimal.valueOf(3000));
		empl.setPerfil(pdao.buscarUno(4));
		empl.setDepartamento(ddao.buscarUno(10));
		empl.setProyectos(null);
		 
		System.out.println(" eliminando : " + edao.eliminar(120));
		
		
	}

	public static void uno() {
		
		System.out.println("BUSCAR UNO");
		System.out.println(edao.buscarUno(115));
		
	}

	
	public static void todos() {
		
		System.out.println("BUSCAR TODOS");
		
		edao.buscarTodos().forEach(System.out::println);// se bucla por que es una relacion cruzada dentro de empleados hay un proyecto y dentro de proyecto hay un empleado
		
	}
	
		
	public static void empleadosByDepartamento() {
			
			
			System.out.println(edao.empleadosByDepartamento(10));
			
		}
	
	public static void empleadosBySexo() {
		
		System.out.println(edao.empleadosBySexo("M"));
		
	}
	
	
	public static void empleadosByApellido() {
		
		
		System.out.println(edao.empleadosByApellido("Himuro"));
		
	}
	
	public static void salarioTotal() {
		
		
		System.out.println(edao.salarioTotal());
		
	}
	
	public static void salarioTotalINT() {
		
		System.out.println(edao.salarioTotal(10));
	
		
	}
	
	
	
	}

