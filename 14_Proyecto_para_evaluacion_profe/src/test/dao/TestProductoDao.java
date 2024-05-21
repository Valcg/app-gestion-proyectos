package test.dao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import modelo.dao.FamiliaDao;
import modelo.dao.FamiliaDaoImplMy8Jpa;
import modelo.dao.ProductoDao;
import modelo.dao.ProductoDaoImplMy8Jpa;
import modelo.entidades.Producto;

public class TestProductoDao {
	
private static ProductoDao pdao ;
private static FamiliaDao fadao;
	
	
	static {
		
		pdao = new ProductoDaoImplMy8Jpa();
		fadao = new FamiliaDaoImplMy8Jpa();
		
}
	
	
	public static void main(String[] args) throws ParseException {
		//todos();
		//uno();
		alta();
		//eliminar();
		
		
}
	
	public static void alta() throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		 Producto producto1 = new Producto();
		 producto1.setDescripcion("teclado");
		 producto1.setFamilia(fadao.buscarUno(2));
		 producto1.setFechaCreacion(sdf.parse("2019-04-02"));
		 producto1.setPrecio(BigDecimal.valueOf(500));
		 producto1.setStock(100);
		 
		 Producto producto2 = new Producto();
		 producto2.setDescripcion("sillas ergonómicas");
		 producto2.setFamilia(fadao.buscarUno(2));
		 producto2.setFechaCreacion(sdf.parse("2019-04-05"));
		 producto2.setPrecio(BigDecimal.valueOf(1000));
		 producto2.setStock(50);
		 
		 System.out.println("alta : " + pdao.alta(producto1));
		 System.out.println("alta : " + pdao.alta(producto2));
		
	}

}
