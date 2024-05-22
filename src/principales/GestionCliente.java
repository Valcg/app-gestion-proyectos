package principales;

import java.math.BigDecimal;
import java.util.Scanner;
import modelo.entidades.Cliente;
import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8Jpa;

// LA PARTE DE CLIENTE 
public class GestionCliente { // PARTE  UTIL DEL USUARIO
	
	private static ClienteDao dao; // CREAMOS OBJT
	private static Scanner leer; // LUEGO ESCANER PARA LEER 
	
	static {
		dao = new ClienteDaoImplMy8Jpa(); // IMPLEMENTAMOS METODOS DE LA BBDD
		leer = new Scanner(System.in); // LEEMOS
	}
	
	public static void main(String[] args) {
				
		int opc = 0;
		System.out.println("ingrese" );
		Scanner leer = new Scanner(System.in);	
		opc = leer.nextInt();
		while(opc >= 5) {
			
			if( opc == 1){		
				altaCliente();
				break;
			}else if( opc  == 2){
				buscarCliente();
				break;
			}else if (opc == 3) {
				mostrarTodos();
				break;		
			}else if(opc == 4){
				eliminarCliente();
				break;
			}else if(opc == 5){	
				break;		
			}else {
				break;
			}
		}
		
		//opc >= 1 && opc < 5
	
		System.out.println("---------------");
		
		eliminarCliente();
		mostrarTodos();		
		buscarCliente();
		altaCliente();
		
	}
	

	public static void eliminarCliente() { 
		System.out.println(" ELIMINAR -----------");
		String clave = leer.next(); // QUE LO LEA
		Cliente cliente = dao.eliminar(clave); // llamamos al metodo de CLI-IMPL8JPA
		if(dao.buscarUno(clave) == null) {
			System.out.println( "YA ESTA ELIMINADO "); // SI BUSCAMOS ES IGUAL A UNO ELIMINADO
		} else {
			System.out.println(" NO ESTA ELIMINADO ");
		}	
	}

	public static void mostrarTodos() {
		dao.buscarTodos().forEach(System.out::println);		
	}

	public static void buscarCliente() {
		
		System.out.println(" BUSCAR -----------");
		String clave = leer.next();
		Cliente cliente  = dao.buscarUno ("A");
	}

	public static void altaCliente() {
		System.out.println(" ALTA -----------");
		
		Cliente cli = new Cliente();
	
	
		cli.setCif(leer.next());
		cli.setNombre(leer.next());
		cli.setApellidos(leer.next());
		cli.setDomicilio(leer.next());
		cli.setFacturacionAnual(leer.nextBigDecimal());
		cli.setNumeroEmpleados(leer.nextInt());		
	}
	
	public static int PINTARMENU() {
		int cli = 0;
		System.out.println("--------------- OPCIONES DE 1 A 5 ---------------");
	
		System.out.println("--------------- 1. Alta del Cliente");
		System.out.println("--------------- 2. Buscar un Cliente");
		System.out.println("--------------- 3. Mostrar Todos");
		System.out.println("--------------- 4. Eliminar un cliente");
		System.out.println("--------------- 5. Salir");		
		
		cli = leer.nextInt();
		while(cli <1|| cli > 5 ){
			System.out.println("solo del 1 al 5");
		cli=leer.nextInt();	
		}
		return cli;
		 //
	}

}

// IMPORTE DE VETNA DE PROYECTOS EES VENTA PREVISTA 
// RRHH - NO HAY JEFE DE DEPARTAMENTO - QUITAR 
