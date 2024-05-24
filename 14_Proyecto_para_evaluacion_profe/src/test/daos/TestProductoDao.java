package test.daos;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8JPA;
import modelo.dao.DepartamentoDao;
import modelo.dao.DepartamentoDaoImplMy8JPA;
import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImplMy8JPA;
import modelo.dao.ProductoDao;
import modelo.dao.ProductoDaoImplMy8JPA;
import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8JPA;
import modelo.entidades.Departamento;
import modelo.entidades.Producto;

public class TestProductoDao {
	
	private static ProyectoDao pdao;
	private static ClienteDao cdao;
	private static EmpleadoDao edao;
	private static ProductoDao pddao;
	
	static {
		pdao = new ProyectoDaoImplMy8JPA();
		cdao = new ClienteDaoImplMy8JPA();
		edao = new EmpleadoDaoImplMy8JPA();
		pddao = new ProductoDaoImplMy8JPA();
	}
	
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public static void main(String[] args) throws ParseException{
		// alta();
		// eliminar();
		// buscarUno();
		buscarTodos();
	}


	private static void buscarTodos() {
		pddao.buscarTodos().forEach(System.out::println);
	}

	private static void buscarUno() {
		System.out.println(pddao.buscarUno(1));
		
	}

	private static void eliminar() {
	System.out.println(pddao.eliminar(1));
	}

	private static void alta() throws ParseException{
		Producto producto1 = new Producto();
		producto1.setDescripcion("Ordenador");
		producto1.setFamilia(null);
		producto1.setFechaCreacion(sdf.parse("2020-04-21"));
		producto1.setPrecio(BigDecimal.valueOf(300.00));
		producto1.setStock(200);
	}

}
