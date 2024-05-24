package test.daos;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import modelo.dao.FamiliaDao;
import modelo.dao.FamiliaDaoImplMy8Jpa;
import modelo.dao.ProductoDao;
import modelo.dao.ProductoDaoImplMy8Jpa;
import modelo.entidades.Producto;
import modelo.entidades.Familia;

public class TestProductoDao {

	
	private static FamiliaDao fdao;
	
	private static ProductoDao pdao;
	
	static {		 
		pdao= new ProductoDaoImplMy8Jpa(); 
		fdao= new FamiliaDaoImplMy8Jpa(); 
	
	}
	
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	 
	 public static void main(String[] args) throws ParseException  {	
		uno();
		todos();
		//alta();
		//eliminar();
		}

	private static void eliminar() {
		System.out.println("------------------ELIMINAR");
		//System.out.println("eliminar" + pdao.eliminar()); // ID_PRODUCTO
	}

/*	private static void alta() throws ParseException  {
		System.out.println("------------------ALTA");
		Producto  prod = new Producto();
		
		prod.setDescripcion("Portatil");
		prod.setFamilia(null);
		prod.setFechaCreacion(sdf.parse("2024-02-22"));
		// sin IdProducto
		prod.setPrecio(BigDecimal.valueOf(200.00));
		prod.setStock(30);
		System.out.println(pdao.alta(prod));
		todos();// LLAMAMOS A BUSCARTODOS	
	} */

	private static void todos() {
		System.out.println("------------------BUSCAR TODOS");
		pdao.buscarTodos().forEach(System.out::println);	
	}

	private static void uno() {
		System.out.println("------------------BUSCAR UNO");
		System.out.println(pdao.buscarUno(1));			
	}

	

}
