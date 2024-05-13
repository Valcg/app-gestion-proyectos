package test.dao;


import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8Jpa;
import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImplMy8Jpa;
import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8Jpa;
import modelo.entidades.Proyecto;


public class TestProyectoDao {
	
	private static ProyectoDao prdao ;
	private static ClienteDao cdao ;
	private static EmpleadoDao edao ;
	
	
	
	
	static {
		
	
		prdao = new ProyectoDaoImplMy8Jpa();
		cdao = new ClienteDaoImplMy8Jpa();
		edao = new EmpleadoDaoImplMy8Jpa();
}
	
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	
public static void main(String[] args) throws ParseException {
		alta();
		//proyectosByCliente();
		//todos();
		//uno();
		//eliminar();
		//proyectosByEstado();
		//proyectosByJefeProyectoAndByEstado();
		//importesVentaProyectosTerminados();
		//margenBrutoProyectosTerminados();
		//diasATerminoProyectoActivo();

		
}	


		public static void alta() throws ParseException {
	
			Proyecto pr = new Proyecto();
			pr.setIdProyecto("bd2024003");
			pr.setCosteReal(BigDecimal.valueOf(100000));
			pr.setCostesPrevisto(BigDecimal.valueOf(80000));
			pr.setDescripcion("creacion de base de datos para secretaría");
			pr.setEstado("Activo");
			pr.setFechaFinPrevisto(sdf.parse("2023-05-15"));
			pr.setFechaFinReal(sdf.parse("2023-07-15"));
			pr.setFechaInicio(sdf.parse("2023-01-15"));
			pr.setVentaPrevisto(BigDecimal.valueOf(200000));
			pr.setCliente(cdao.buscarUno("A22222222"));
			pr.setEmpleado(edao.buscarUno(119));
			
			Proyecto pr1 = new Proyecto();
			pr1.setIdProyecto("bbbdddd2024004");
			pr1.setCosteReal(BigDecimal.valueOf(50000));
			pr1.setCostesPrevisto(BigDecimal.valueOf(40000));
			pr1.setDescripcion("creacion de base de datos para materiales");
			pr1.setEstado("Terminado");
			pr1.setFechaFinPrevisto(sdf.parse("2023-02-15"));
			pr1.setFechaFinReal(sdf.parse("2023-03-15"));
			pr1.setFechaInicio(sdf.parse("2022-08-15"));
			pr1.setVentaPrevisto(BigDecimal.valueOf(200000));
			pr1.setCliente(cdao.buscarUno("D66666666"));
			pr1.setEmpleado(edao.buscarUno(118));
			
			//System.out.println(prdao.alta(pr));

			System.out.println(prdao.alta(pr1));
			
	
}
		
		public static void eliminar() {
			
			 
			System.out.println(" eliminando : " + prdao.eliminar("bd2024004"));
			
			
		}

		public static void uno() {
			
			System.out.println("BUSCAR UNO");
			System.out.println(prdao.buscarUno("FOR2020001"));
			
		}

		
		public static void todos() {
			
			System.out.println("BUSCAR TODOS");
			
			prdao.buscarTodos().forEach(System.out::println);// se bucla por que es una relacion cruzada dentro de empleados hay un proyecto y dentro de proyecto hay un empleado
			
		}
		
		public static void proyectosByEstado() {
			
			prdao.proyectosByEstado("Activo").forEach(System.out::println);
		}
			
		public static void proyectosByCliente() {
			
			prdao.proyectosByCliente("A22222222").forEach(System.out::println);
		}
		
		public static void proyectosByJefeProyectoAndByEstado() {
			
			prdao.proyectosByJefeProyectoAndByEstado(114,"Terminado").forEach(System.out::println);
			
			prdao.proyectosByJefeProyectoAndByEstado(115,"Terminado").forEach(System.out::println);
		}
		
		public static void importesVentaProyectosTerminados() {
			
			System.out.println(prdao.importesVentaProyectosTerminados());
			
		
		}
		
		public static void margenBrutoProyectosTerminados() {
			
			System.out.println(prdao.margenBrutoProyectosTerminados());
			
		
		}
		
	public static void diasATerminoProyectoActivo() {
			
			System.out.println(prdao.diasATerminoProyectoActivo("FOR2021001"));
			
		
		}
		
		
		
		

}
