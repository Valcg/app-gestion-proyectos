package test.dao;

import java.math.BigDecimal;

import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImplMy8Jpa;
import modelo.entidades.Empleado;


public class TestEmpleadoDao {

private static EmpleadoDao edao ;
	
	
	static {
		
		edao = new EmpleadoDaoImplMy8Jpa();
}
	
	
	
	public static void main(String[] args) {
		//todos();
		uno();
		//alta();
		//eliminar();
}
	
	public static void alta() {
		
		Empleado empl = new Empleado();
		empl.setNombre("petra");
		empl.setApellidos("pera");
		empl.setGenero("M");
		empl.setPassword("root");
		empl.setSalario(BigDecimal.valueOf(3000));
		//empl.setPerfil();
		//empl.setDepartamento();
			
		 
		System.out.println(edao.alta(empl));
		todos();
		
		
	}
	
	public static void eliminar() {
		
		/*Empleado empl = new Empleado();
		empl.setNombre("petra");
		empl.setApellidos("pera");
		empl.setGenero("M");
		empl.setPassword("root");
		empl.setSalario(BigDecimal.valueOf(3000));
		empl.setPerfil();
		empl.setDepartamento();*/
		 
		System.out.println(" eliminando : " + edao.eliminar("120"));
		
		
	}

	public static void uno() {
		
		System.out.println("BUSCAR UNO");
		System.out.println(edao.buscarUno("115"));
		
	}

	
	public static void todos() {
		
		System.out.println("BUSCAR TODOS");
		
		edao.buscarTodos().forEach(System.out::println);
		
	}

}
