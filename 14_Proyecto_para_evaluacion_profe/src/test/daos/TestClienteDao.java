package test.daos;

import java.math.BigDecimal;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8JPA;
import modelo.entidades.Cliente;

public class TestClienteDao {
	
	private static ClienteDao cdao;
	static {
		cdao = new ClienteDaoImplMy8JPA();
		}
	
	public static void main(String[] args) {
		alta();
		eliminar();
		buscarUno();
		buscarTodos();
	}
	
	public static void alta() {
		Cliente cliente = new Cliente();
		cliente.setApellidos("González");
		cliente.setCif("C44444444");
		cliente.setDomicilio("Calle Getafe, 23");
		cliente.setFacturacionAnual(BigDecimal.valueOf(50000));
		cliente.setNombre("Lucía");
		cliente.setNumeroEmpleados(27);
		System.out.println(cdao.alta(cliente));
		buscarTodos();
	}
	
	public static void eliminar() {
		Cliente cliente = new Cliente("C44444444","Lucía","González","Calle Getafe, 23",BigDecimal.valueOf(50000), 23);
		System.out.println("Eliminado" + cdao.eliminar("C44444444"));
	}
	
	public static void buscarUno() {
		System.out.println(cdao.buscarUno("C44444444"));
	}
	
	public static void buscarTodos() {
		cdao.buscarTodos().forEach(System.out::println);
	}

}
