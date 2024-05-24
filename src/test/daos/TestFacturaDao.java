package test.daos;

import java.text.SimpleDateFormat;

import modelo.dao.FacturaDao;
import modelo.dao.FacturaDaoImplMy8Jpa;
import modelo.entidades.Factura;

public class TestFacturaDao {

	
private static FacturaDao fdao;
	
	static {	
		fdao= new FacturaDaoImplMy8Jpa(); 
		}
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public static void main(String[] args) {
		uno();
		todos();
		//eliminar();
		//	alta();

	}
	private static void uno() {
		System.out.println("------------------BUSCAR UNO");
		System.out.println(fdao.buscarUno("F2020001"));	
		
	}

	private static void todos() {
		System.out.println("------------------BUSCAR TODOS");
		fdao.buscarTodos().forEach(System.out::println);
		
	}

	private static void eliminar() {
		System.out.println("------------------ELIMINAR");
	//	System.out.println("eliminar" + fdao.eliminar("F2020001"));
		
	}

	private static void alta() {
		System.out.println("------------------ALTA");
		
		Factura factura = new Factura();
		factura.setIdFactura("F2020002");
		factura.setDescripcion("Otros");
		factura.setFechaFactura(null); // sdf.parse("1990-02-22")
		factura.setProyecto(null);
		
		System.out.println(fdao.alta(factura));
		todos();// LLAMAMOS A BUSCARTODOS	
	}

}
