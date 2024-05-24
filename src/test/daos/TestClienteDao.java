package test.daos;

import java.math.BigDecimal;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8Jpa;
import modelo.entidades.Cliente;


public class TestClienteDao {

	private static ClienteDao dao; // HACEMOS EL OBJ , que se llama dao - TRABAJAMOS CON ESTO

	static{
	
		dao = new ClienteDaoImplMy8Jpa();	//NOS COMUNICAMOS CON LA BBDD										// CAMBIAMOS POR LO QUE TENEMOS EN EL GENCRUD POR L ODE CLI Y OBJ
	}
	
	public static void main(String[] args) {	
		uno();
		todos();
	//	alta();
	//	eliminar();
	}
	
	private static void eliminar() {
		System.out.println("------------------ELIMINAR");
		//Cliente cli = new Cliente("C55555555","Borja","Borjita","Bilbao",BigDecimal.valueOf(1000000),555);
		System.out.println("eliminar" + dao.eliminar("C55555555"));	
		System.out.println("eliminar" + dao.eliminar("C77777777"));	
	}

	private static void alta() {
		System.out.println("------------------ALTA");
		Cliente  cli = new Cliente();
		
		cli.setCif("C1111111");
		cli.setNombre("Ariana");
		cli.setApellidos("arianita");
		cli.setDomicilio("Alcampo");
		cli.setFacturacionAnual(BigDecimal.valueOf(110000L)); // PARA NUM CON BIG DECIMAL,
		//TENEMOS QUE CONVERTIRLO, ES UNA CLASE, QUE LO CONVIERTE, PODEMOS PONER UN NUMERO NORMAL Y EL LO CONVIERTE
		// LA L LO USAMOS EN NUMEROS LARGOS PARA AVISAR -- LONG
		cli.setNumeroEmpleados(100);	
				
		System.out.println(dao.alta(cli));
		todos();// LLAMAMOS A BUSCARTODOS		
	}

	private static void todos() {
		System.out.println("------------------BUSCAR TODOS");
		dao.buscarTodos().forEach(System.out::println);	
	}
	private static void uno() { // CLAVE -ES DNI O CIF
		System.out.println("------------------BUSCAR UNO");
		System.out.println(dao.buscarUno("C44444444"));			
	}
	
}
