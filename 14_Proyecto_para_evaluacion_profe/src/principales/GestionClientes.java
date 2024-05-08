package principales;

import java.util.Scanner;
import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8Jpa;
import modelo.entidades.Cliente;




public class GestionClientes {
	
	private static ClienteDao cdao;
	private static Scanner leer;
	
	


	static {
		
		cdao = new ClienteDaoImplMy8Jpa();
		leer = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
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
				
					
				}while (opcion >= 1 && opcion < 5 );
		
		System.out.println("fin programa");
		 
		}
	
	public static void eliminarCliente() {
		

		String cif = leer.next();
		Cliente cliente = cdao.eliminar(cif);
		
		if(cdao.buscarUno(cif) == null)
			System.out.println("cliente eliminado ");
		else
			System.out.println("no se eliminó");
	
		
	
		
	}
	


	public static void buscarUnCliente() {
		
		System.out.println("dame el cif del cliente");
		String cif = leer.next();
		Cliente cliente = cdao.buscarUno(cif);
		
		if (cliente != null)
			System.out.println("Tu cliente es : " + cliente);
		else 
			System.out.println("cliente no encontrado ");
	
		}
		
	

	public static void altaCliente() {
		
		Cliente cliente = new Cliente();
		
		cliente.setCif(leer.next());
		cliente.setNombre(leer.next());
		cliente.setApellidos(leer.next());
		cliente.setDomicilio(leer.next());
		cliente.setFacturacionAnual(leer.nextBigDecimal());
		cliente.setNumeroEmpleados(leer.nextInt());
		
		
		
		if(cdao.alta(cliente) )
			System.out.println("alta realizada");
		else
			System.out.println("no se pudo dar el alta");
		
	}
	
	public static void buscarTodosClientes() {
		for (Cliente clientes: cdao.buscarTodos()) {
			
			System.out.println(clientes);
	}
		
	}

	public static  int pintarMenu() {
		int opcion=0;
		 System.out.println("1. -Alta del cliente");
		 System.out.println("2. -buscar un cliente");
		 System.out.println("3. -mostrar todos ");
		 System.out.println("4. -eliminar un cliente");
		 System.out.println("5. -salir");
		
		 System.out.println("opcion del 1 al 5");
		 
		 opcion = leer.nextInt();
		 System.out.println();
		  while (opcion <1 || opcion > 5) {
			  System.out.println("solo opciones del 1 al 5");
			  opcion=leer.nextInt();
			  // pa qu e no coja el carcater de contrl de carro que no hacogido el nextINT
			  System.out.println();
		  }
		  
		  return opcion;
}
	
	
	
}


//double-double 
// decimal(11,2) => BigDecimal.valueof(7.2)
// decimal es bigdecimal y tiene un metodo estatica de value of para pasarlo a decimal 

