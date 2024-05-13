package principales;

import java.util.Scanner;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8JPA;
import modelo.entidades.Cliente;

public class GestionClientes {
	
	private static ClienteDao cdao;
	private static Scanner Leer;
	
	
	static {
		cdao = new ClienteDaoImplMy8JPA();
		Leer = new Scanner(System.in);
	}
	
	public static void main(String[] arg) {
		int opcion = 0;
		
		do {
			opcion = pintarMenu();
			
			if (opcion == 5)
				break;
			
				switch (opcion) {
				case 1:
					altaCliente();
					break;
					
				case 2:
					buscarUnCliente();
					break;
					
				case 3:
					buscarTodosClientes();
					break;
					
				case 4:
					eliminarCliente();
					break;
				}
		} while (opcion >= 1 && opcion < 5);
		
		System.out.println("Fin programa");
	}
	
	public static void eliminarCliente() {
		String cif = Leer.next();
		Cliente cliente = cdao.eliminar(cif);
		
		if(cdao.buscarUno(cif) == null)
			System.out.println("Cliente eliminado");
		else
			System.out.println("Cliente no ha sido eliminado");
	}
	
	public static void buscarUnCliente() {
		System.out.println("Teclea el CIF del cliente");
		String cif = Leer.next();
		Cliente cliente = cdao.buscarUno(cif);
		
		if(cliente != null)
			System.out.println("Tu cliente es: " + cliente);
		else
			System.out.println("Cliente no encontrado");
	}
	
	public static void altaCliente() {
		Cliente cliente = new Cliente();
		
		cliente.setCif(Leer.next());
		cliente.setNombre(Leer.next());
		cliente.setApellidos(Leer.next());
		cliente.setDomicilio(Leer.next());
		cliente.setFacturacionAnual(Leer.nextBigDecimal());
		cliente.setNumeroEmpleados(Leer.nextInt());
		
		if(cdao.alta(cliente) )
			System.out.println("Cliente dado de alta");
		else
			System.out.println("Cliente no ha sido dado de alta");
	}
	
	public static void buscarTodosClientes() {
		for (Cliente clientes:cdao.buscarTodos()) {
			System.out.println(clientes);
		}
	}
	
	public static int pintarMenu() {
		int opcion = 0;
		System.out.println("1. Alta del cliente");
		System.out.println("2. Buscar un cliente");
		System.out.println("3. Mostrar todos");
		System.out.println("4. Eliminar un cliente");
		System.out.println("5. Salir");
		
		System.out.println("Opcion del 1 al 5");
		
		
		opcion = Leer.nextInt();
		while (opcion <1 || opcion <5) {
			System.out.println("Solo opciones del 1 al 5");
			opcion = Leer.nextInt();
		}
		
		return opcion;
	}
	

}
