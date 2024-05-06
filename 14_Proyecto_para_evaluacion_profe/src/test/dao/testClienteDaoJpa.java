package test.dao;

import java.math.BigDecimal;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8Jpa;
import modelo.entidades.Cliente;




public class testClienteDaoJpa {
	
	
	private static ClienteDao cdao ;
	
	
	static {
		
		cdao = new ClienteDaoImplMy8Jpa();
}
	
	
	public static void main(String[] args) {
		//todos();
		//uno();
		alta();
		//eliminar();
}
	
	public static void alta() {
		
		
		 Cliente cliente = new Cliente();
		 	cliente.setCif("C44444444");
			cliente.setNombre("daniela");
			cliente.setApellidos("pastrano");
			cliente.setDomicilio("Aranjuez");
			cliente.setFacturacionAnual(BigDecimal.valueOf(1500005L));
			cliente.setNumeroEmpleados(3000);
			
		 
		System.out.println(cdao.alta(cliente));
		todos();
		
		
	}
	
	public static void eliminar() {
		
		
		 Cliente cliente = new Cliente("C44444444","daniela","pastrano","Aranjuez",BigDecimal.valueOf(1500005L),3000); 
		System.out.println(" eliminando : " + cdao.eliminar("C44444444"));
		
		
	}

	public static void uno() {
		
		System.out.println("BUSCAR UNO");
		System.out.println(cdao.buscarUno("A22222222"));
		System.out.println(cdao.buscarUno("B33333333"));
	}

	
	public static void todos() {
		
		System.out.println("BUSCAR TODOS");
		
		cdao.buscarTodos().forEach(System.out::println);
		
	}

}
