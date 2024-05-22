package test.daos;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8JPA;
import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImplMy8JPA;
import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8JPA;
import modelo.entidades.Proyecto;



public class TestProyectoDao {
	
	private static ProyectoDao pdao;
	private static ClienteDao cdao;
	private static EmpleadoDao edao; 
	
	
	static {
		pdao = new ProyectoDaoImplMy8JPA();
		cdao = new ClienteDaoImplMy8JPA();
		edao = new EmpleadoDaoImplMy8JPA();
	}
	
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public static void main(String[] args) throws ParseException {
		alta();
		// eliminar();
		// buscarUno();
		// buscarTodos();
		// proyectosByEstado();
		// proyectosByCliente();
		// proyectosByJefeProyectoAndByEstado();
		// importesVentaProyectosTerminados();
		// margenBrutoProyectosTerminados();
		// diasATerminoProyectoActivo();
	}
	
	
	

	private static void diasATerminoProyectoActivo() {
		System.out.println(pdao.diasATerminoProyectoActivo("FOR2021001"));
		
	}




	private static void margenBrutoProyectosTerminados() {
		System.out.println(pdao.margenBrutoProyectosTerminados());
		
	}




	private static void importesVentaProyectosTerminados() {
		System.out.println(pdao.importesVentaProyectosTerminados());
		
	}




	private static void proyectosByJefeProyectoAndByEstado() {
		System.out.println(pdao.proyectosByJefeProyectoAndByEstado(114, "TERMINADO"));
		
	}




	private static void proyectosByCliente() {
		System.out.println(pdao.proyectosByCliente("A22222222"));
		
	}




	private static void proyectosByEstado() {
		System.out.println(pdao.proyectosByEstado("TERMINADO"));
		
	}



	private static void buscarTodos() {
		pdao.buscarTodos().forEach(System.out::println);
		
	}

	private static void buscarUno() {
		System.out.println(pdao.buscarUno("BD001"));
		
	}

	private static void eliminar() {
		System.out.println(pdao.eliminar("FOR2020005"));
		System.out.println(pdao.eliminar("FOR2020003"));
		System.out.println(pdao.eliminar("FOR2020006"));
		
	}

	private static void alta() throws ParseException {
		Proyecto proyecto1 = new Proyecto();
		proyecto1.setCliente(cdao.buscarUno("A22222222"));
		proyecto1.setEmpleado(edao.buscarUno(114));
		proyecto1.setCosteReal(BigDecimal.valueOf(315000.00));
		proyecto1.setCostesPrevisto(BigDecimal.valueOf(30000.00));
		proyecto1.setDescripcion("Creando base de datos");
		proyecto1.setEstado("TERMINADO");
		proyecto1.setFechaFinPrevisto(sdf.parse("2020-07-31"));
		proyecto1.setFechaFinReal(sdf.parse("2020-07-31"));
		proyecto1.setFechaInicio(sdf.parse("2020-01-15"));
		proyecto1.setIdProyecto("BD002");
		proyecto1.setVentaPrevisto(BigDecimal.valueOf(50000.00));
		
		Proyecto proyecto2 = new Proyecto();
		proyecto2.setCliente(cdao.buscarUno("B33333333"));
		proyecto2.setEmpleado(edao.buscarUno(120));
		proyecto2.setCosteReal(BigDecimal.valueOf(405000.00));
		proyecto2.setCostesPrevisto(BigDecimal.valueOf(40000.00));
		proyecto2.setDescripcion("Formacion de habilidades directivas");
		proyecto2.setEstado("TERMINADO");
		proyecto2.setFechaFinPrevisto(sdf.parse("2020-09-15"));
		proyecto2.setFechaFinReal(sdf.parse("2020-09-16"));
		proyecto2.setFechaInicio(sdf.parse("2020-03-25"));
		proyecto2.setIdProyecto("FOR2020006");
		proyecto2.setVentaPrevisto(BigDecimal.valueOf(50000.00));
		
		Proyecto proyecto3 = new Proyecto();
		proyecto3.setCliente(cdao.buscarUno("B33333333"));
		proyecto3.setEmpleado(edao.buscarUno(118));
		proyecto3.setCostesPrevisto(BigDecimal.valueOf(35000.00));
		proyecto3.setDescripcion("Formacion de habilidades directivas");
		proyecto3.setEstado("ACTIVO");
		proyecto3.setFechaFinPrevisto(sdf.parse("2020-08-10"));
		proyecto3.setFechaInicio(sdf.parse("2020-04-21"));
		proyecto3.setIdProyecto("FOR2020004");
		proyecto3.setVentaPrevisto(BigDecimal.valueOf(55000.00));
		
		System.out.println(pdao.alta(proyecto1));
		//System.out.println(pdao.alta(proyecto2));
		
	}
	
	

}
