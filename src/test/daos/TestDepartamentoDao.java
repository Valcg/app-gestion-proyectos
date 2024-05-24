package test.daos;

import java.math.BigDecimal;

import modelo.dao.DepartamentoDao;
import modelo.dao.DepartamentoDaoImplMy8Jpa;
import modelo.entidades.Departamento;

public class TestDepartamentoDao {

	private static DepartamentoDao ddao;
	
	static {		 
	ddao= new DepartamentoDaoImplMy8Jpa(); 
	// cliente, proyecto,empleado
	
	}
	 
	 public static void main(String[] args) {	
			uno();
			todos();
		//	alta();
			//eliminar();
		}

	private static void eliminar() {
		System.out.println("------------------ELIMINAR");
		System.out.println("eliminar" + ddao.eliminar(30));
	}

	private static void alta() {
		System.out.println("------------------ALTA");
		Departamento  dep = new Departamento();
		
		dep.setNombre("Manenimiento");
		dep.setDireccion("Murcia");
		dep.setIdDepar(50);
			
		Departamento  dep2 = new Departamento();
		dep2.setNombre("RecursosHumanos");
		dep2.setDireccion("Menorca");
		dep2.setIdDepar(60);
		System.out.println(ddao.alta(dep));
		System.out.println(ddao.alta(dep2));
		todos();// LLAMAMOS A BUSCARTODOS	
	}

	private static void todos() {
		System.out.println("------------------BUSCAR TODOS");
		ddao.buscarTodos().forEach(System.out::println);	
	}

	private static void uno() {
		System.out.println("------------------BUSCAR UNO");
		System.out.println(ddao.buscarUno(20));			
	}
		
	
}
