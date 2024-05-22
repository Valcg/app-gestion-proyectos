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
		alta();
		//eliminar();
	}
	
	private static void eliminar() {
		Cliente cli = new Cliente("A222222","Borja","Borjita","Bilbao",BigDecimal.valueOf(220000),20000);
		System.out.println("eliminar" + dao.eliminar("A222222"));	
	}

	private static void alta() {	
		Cliente  cli = new Cliente();
		
		cli.setCif("A1111111");
		cli.setNombre("Ariana");
		cli.setApellidos("arianita");
		cli.setDomicilio("Alcampo");
		cli.setFacturacionAnual(BigDecimal.valueOf(110000L)); // PARA NUM CON BIG DECIMAL
		// LA L LO USAMOS EN NUMEROS LARGOS PARA AVISAR -- LONG
		cli.setNumeroEmpleados(100);	
		System.out.println(dao.alta(cli));
		todos();// LLAMAMOS A BUSCARTODOS		
	}


	private static void todos() {
		dao.buscarTodos().forEach(System.out::println);	
	}
	private static void uno() { // CLAVE -ES DNI O CIF
		System.out.println(dao.buscarUno("A1111111"));			
	}

	
	
}
