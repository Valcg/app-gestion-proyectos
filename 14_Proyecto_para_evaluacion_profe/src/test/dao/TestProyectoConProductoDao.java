package test.dao;

import java.util.ArrayList;
import java.util.List;
import modelo.dao.ProductoDao;
import modelo.dao.ProductoDaoImplMy8Jpa;
import modelo.dao.ProyectoConProductoDao;
import modelo.dao.ProyectoConProductoDaoImplMy8Jpa;
import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8Jpa;
import modelo.entidades.Producto;
import modelo.entidades.Proyecto;
import modelo.entidades.ProyectoConProducto;

public class TestProyectoConProductoDao {
	
	private static ProyectoConProductoDao pedao ;
	private static ProductoDao ppdao;
	private static ProyectoDao pdao;
	
	static {
		pedao = new ProyectoConProductoDaoImplMy8Jpa();
		ppdao = new ProductoDaoImplMy8Jpa();
		pdao = new ProyectoDaoImplMy8Jpa();
		
	}
	
	
public static void main(String[] args) {
		
	 
		Proyecto proyecto1 =  pdao.buscarUno("bd2024004");
		Producto pro1 = ppdao.buscarUno(1);
		Producto pro2 = ppdao.buscarUno(2);
		Producto pro3 = ppdao.buscarUno(3);
		 
		
		List<ProyectoConProducto> productos = new ArrayList<>();
		 
		ProyectoConProducto producto1 = new ProyectoConProducto();
		producto1.setCantidad(35);
		producto1.setProyecto(proyecto1);
		producto1.setPrecioAsignado(10000);
		producto1.setProducto(pro1);
		
		ProyectoConProducto producto2 = new ProyectoConProducto();
		producto2.setCantidad(80);
		producto2.setProyecto(proyecto1);
		producto2.setPrecioAsignado(300);
		producto2.setProducto(pro2);
		
		ProyectoConProducto producto3 = new ProyectoConProducto();
		producto3.setCantidad(45);
		producto3.setProyecto(proyecto1);
		producto3.setPrecioAsignado(400);
		producto3.setProducto(pro3);
		
	        
		productos.add(producto1);
		productos.add(producto2);
		productos.add(producto3);
		

		asignarProductoAProyecto(productos);
		
	}

	public static void asignarProductoAProyecto(List<ProyectoConProducto> productos) {
	
		System.out.println(pedao.asignarProductoAProyecto(productos));
	
}
	

}
