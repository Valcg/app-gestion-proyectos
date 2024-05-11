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
			
			Cliente cliente3 = new Cliente();
			cliente3.setCif("E66666666");
			cliente3.setNombre("mario");
			cliente3.setApellidos("castro");
			cliente3.setDomicilio("Gran via");
			cliente3.setFacturacionAnual(BigDecimal.valueOf(400000000L));
			cliente3.setNumeroEmpleados(1000);
		
			Cliente cliente4 = new Cliente();
			cliente4.setCif("D66666666");
			cliente4.setApellidos("lupe");
			cliente4.setDomicilio("torrejon");
			cliente4.setFacturacionAnual(BigDecimal.valueOf(1500005L));
			cliente4.setNombre("maria");
			cliente4.setNumeroEmpleados(700);
			
		 Cliente cliente5 = new Cliente("C44444488","dani","pasto","Aranjuez",BigDecimal.valueOf(1500005L),3000); 
			
			
			System.out.println("dando el alta ");
			
			/*System.out.println(cdao.alta(cliente));
			System.out.println(cdao.alta(cliente3));
			System.out.println(cdao.alta(cliente4));*/
			System.out.println(cdao.alta(cliente5));
	
	
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
