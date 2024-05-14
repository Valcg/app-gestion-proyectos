package test.dao;
import modelo.dao.DepartamentoDao;
import modelo.dao.DepartamentoDaoImplMy8Jpa;

import modelo.entidades.Departamento;


public class TestDepartamentoDao {
	
	private static DepartamentoDao ddao ;
		
		
		static {
			
		
			ddao = new DepartamentoDaoImplMy8Jpa();
	}
		

		
		
		
	public static void main(String[] args) {
			alta();
			//todos();
			//uno();
			//eliminar();

			
	}			
			public static void alta() {
				
				
			
			Departamento dep1 = new Departamento();
			dep1.setNombre("Recursos Humanos");
			dep1.setDireccion("Almeria");
			dep1.setIdDepar(50);
			
			Departamento dep2 = new Departamento();
			dep2.setNombre("Almacenes");
			dep2.setDireccion("madrid");
			dep2.setIdDepar(60);
			
			Departamento dep3 = new Departamento();
			dep3.setNombre("Incidencias");
			dep3.setDireccion("Madrid");
			dep3.setIdDepar(70);
			
			Departamento dep4 = new Departamento();
			dep4.setNombre("limpieza");
			dep4.setDireccion("Madrid");
			dep4.setIdDepar(80);
			
			
			
				
			 
			System.out.println(ddao.alta(dep1));
			System.out.println(ddao.alta(dep2));
			System.out.println(ddao.alta(dep3));
			System.out.println(ddao.alta(dep4));
			todos();
			
			
		}
		
		public static void eliminar() {
			
			 
			System.out.println(" eliminando : " + ddao.eliminar(80));
			
			
		}

		public static void uno() {
			
			System.out.println("BUSCAR UNO");
			System.out.println(ddao.buscarUno(70));
			
		}

		
		public static void todos() {
			
			System.out.println("BUSCAR TODOS");
			
			ddao.buscarTodos().forEach(System.out::println);// se bucla por que es una relacion cruzada dentro de empleados hay un proyecto y dentro de proyecto hay un empleado
			
		}
		
			

}
