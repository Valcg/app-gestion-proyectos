package test.daos;

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
				
	private static ProyectoDao pdao; // HACEMOS EL OBJ , que se llama dao - TRABAJAMOS CON ESTO
	private static ClienteDao clidao;
	private static EmpleadoDao empdao;
			
	static{
			
		pdao = new ProyectoDaoImplMy8Jpa();	//NOS COMUNICAMOS CON LA BBDD
		clidao = new ClienteDaoImplMy8Jpa();
		empdao = new EmpleadoDaoImplMy8Jpa();
		}		
			
static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
		public static void main(String[] args) throws ParseException {			
			//uno();
			//todos();
    		alta();
    		// eliminar();
    	//	proyByEstados();
    		//	proyByCliente();
    		//	proyByJefeProyectoAndByEstado();
    		//	importesventasTerminados();
    		//margenBrutoProyectosTerminados();
    		//diasTerminoProyectoActivo();
    				
			}			
			private static void diasTerminoProyectoActivo() {
				System.out.println(pdao.diasATerminoProyectoActivo("FOR2021001"));// PROYECTOACTIVO
			
		}
			private static void margenBrutoProyectosTerminados() {
				System.out.println(pdao.margenBrutoProyectosTerminados()); 
			
		}
			private static void importesventasTerminados() {
				System.out.println(pdao.importesVentaProyectosTerminados()); 
			
		}
			private static void proyByJefeProyectoAndByEstado() {
				System.out.println(pdao.proyectosByJefeProyectoAndByEstado(120,"TERMINADO")); // TIENE 2 PARAMETROS 
			
			
		}
			private static void proyByCliente() {
				System.out.println(pdao.proyectosByCliente("B11111111"));
			
		}
			private static void proyByEstados() {
				System.out.println(pdao.proyectosByEstado("TERMINADO"));
			
		}
			private static void eliminar() {		
				System.out.println("eliminar" + pdao.eliminar("B11111111"));		
			}

			private static void alta()  throws ParseException{
				
				Proyecto  proy = new Proyecto();		
				proy.setCliente(clidao.buscarUno("B11111111")); //PROYECTO 1
				proy.setEmpleado(empdao.buscarUno(120));
				proy.setCosteReal(BigDecimal.valueOf(30000.00));
				proy.setCostesPrevisto(BigDecimal.valueOf(40000.00));
				proy.setDescripcion("AltaproyectoDao1");
				proy.setFechaFinPrevisto(sdf.parse("2001-01-22"));
				proy.setFechaFinReal(sdf.parse("2001-01-22"));
				proy.setFechaInicio(sdf.parse("2001-01-11"));
				proy.setEstado("TERMINADO");
				proy.setIdProyecto("FOR1010001");
				proy.setVentaPrevisto(BigDecimal.valueOf(30000.00));			
			
				Proyecto  proy2 = new Proyecto();
				proy2.setCliente(clidao.buscarUno("B33333333")); // PROYECTO 2
				proy2.setEmpleado(empdao.buscarUno(120));
				proy2.setCosteReal(null);
				proy2.setCostesPrevisto(BigDecimal.valueOf(40000));
				proy2.setDescripcion("AltaproyectoDao2");
				proy2.setFechaFinPrevisto(sdf.parse("2023-02-22"));
				proy2.setFechaFinReal(null);
				proy2.setFechaInicio(sdf.parse("2023-02-22"));
				proy2.setEstado("ACTIVO");
				proy2.setIdProyecto("FOR2020002");
				proy2.setVentaPrevisto(BigDecimal.valueOf(33000.00));

			//	todos();// LLAMAMOS A BUSCARTODOS					
				Proyecto  proy3 = new Proyecto();
				proy3.setCliente(clidao.buscarUno("B33333333")); // PROYECTO 3
				proy3.setEmpleado(empdao.buscarUno(120));
				proy3.setCosteReal(BigDecimal.valueOf(30000));
				proy3.setCostesPrevisto(BigDecimal.valueOf(40000));
				proy3.setDescripcion("AltaproyectoDao3");
				proy3.setFechaFinPrevisto(sdf.parse("2013-03-22"));
				proy3.setFechaFinReal(sdf.parse("2013-04-22"));
				proy3.setFechaInicio(sdf.parse("20013-01-22"));
				proy3.setEstado("TERMINADO");
				proy3.setIdProyecto("FOR3030003");
				proy3.setVentaPrevisto(BigDecimal.valueOf(30000.00));
				
				System.out.println(pdao.alta(proy));
				System.out.println(pdao.alta(proy2));
				System.out.println(pdao.alta(proy3));
			}
			
			private static void todos() {
				pdao.buscarTodos().forEach(System.out::println);		
			}
			private static void uno() { 
			
				System.out.println("eliminar" + pdao.buscarUno("FOR1010001"));	
			}
}

