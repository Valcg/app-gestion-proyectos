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
		//	uno();
			todos();
    		//alta();
    		// eliminar();	
    	//	proyByEstados();
    	//	proyByCliente();
    	proyByJefeProyectoAndByEstado();
    		//importesventasTerminados();
    		//margenBrutoProyectosTerminados();
    		//diasTerminoProyectoActivo();
  			
			}			
			private static void diasTerminoProyectoActivo() {
				System.out.println("------------------DIAS TERMINO PROYECTO ACTIVO");
				System.out.println(pdao.diasATerminoProyectoActivo("FOR2020001"));// PROYECTOACTIVO
			
		}
			private static void margenBrutoProyectosTerminados() {
				System.out.println("------------------MARGEN BRUTO PROYECTOS TERMINADOS");
				System.out.println(pdao.margenBrutoProyectosTerminados()); 
			
		}
			private static void importesventasTerminados() {
				System.out.println("------------------IMPORTESVENTAS TERMINADOS");
				System.out.println(pdao.importesVentaProyectosTerminados()); 	
		}
			private static void proyByJefeProyectoAndByEstado() {
				System.out.println("------------------JEFE PROYECTO AND BY ESTADO");
				System.out.println(pdao.proyectosByJefeProyectoAndByEstado(120,"TERMINADO")); // TIENE 2 PARAMETROS 
					
		}
			private static void proyByCliente() {
				System.out.println("------------------POR CLIENTE");
				System.out.println(pdao.proyectosByCliente("A22222222"));
			
		}
			private static void proyByEstados() {
				System.out.println("------------------POR ESTADO");
				System.out.println(pdao.proyectosByEstado("TERMINADO"));
			
		}
			private static void eliminar() {
				System.out.println("------------------ELIMINAR");
				System.out.println("eliminar" + pdao.eliminar("B11111111"));		
			}

			private static void alta()  throws ParseException{
				System.out.println("------------------ALTA");
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
				
				System.out.println(pdao.alta(proy));

			}
			
			private static void todos() {
				System.out.println("------------------TODOS");
				pdao.buscarTodos().forEach(System.out::println);	
				
			}
			private static void uno() { 
				System.out.println("------------------UNO");
			
				System.out.println("eliminar" + pdao.buscarUno("FOR2020001"));	
			}
}

