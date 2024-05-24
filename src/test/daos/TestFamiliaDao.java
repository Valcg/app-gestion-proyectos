package test.daos;


import modelo.dao.FamiliaDao;
import modelo.dao.FamiliaDaoImplMy8Jpa;
import modelo.entidades.Familia;

public class TestFamiliaDao {

	private static FamiliaDao fdao;
	
	static {	
		fdao= new FamiliaDaoImplMy8Jpa(); 
		}
	
	public static void main(String[] args) {
		uno();
		todos();
		//	eliminar();
	//	alta();
	}

	private static void uno() {
		System.out.println("------------------BUSCAR UNO");
		System.out.println(fdao.buscarUno(1));	
		
	}

	private static void todos() {
		System.out.println("------------------BUSCAR TODOS");
		fdao.buscarTodos().forEach(System.out::println);
		
	}

	private static void eliminar() {
		System.out.println("------------------ELIMINAR");
		System.out.println("eliminar" + fdao.eliminar(5));
		
	}

	private static void alta() {
		System.out.println("------------------ALTA");
		
		Familia familia = new Familia();
		familia.setDescripcion("Otros");
		//familia.setIdFamilia(6); ---NO FUNCIONA SI DAMOS DE ALTA EL ID DEL A FAMILIA YA QUE ES NOT NULL AUTOINCREMENT
		
		System.out.println(fdao.alta(familia));
		todos();// LLAMAMOS A BUSCARTODOS	
	}

}
