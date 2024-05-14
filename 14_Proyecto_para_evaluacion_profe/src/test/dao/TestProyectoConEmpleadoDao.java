package test.dao;



import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImplMy8Jpa;
import modelo.dao.ProyectoConEmpleadoDao;
import modelo.dao.ProyectoConEmpleadoDaoImplMy8Jpa;
import modelo.entidades.Empleado;



public class TestProyectoConEmpleadoDao {
	
	private static ProyectoConEmpleadoDao pedao ;
	private static EmpleadoDao edao;
	
	static {
		pedao = new ProyectoConEmpleadoDaoImplMy8Jpa();
		edao = new EmpleadoDaoImplMy8Jpa();
	}
	
	

	public static void main(String[] args) {
		
		//costeActualDeProyecto();
		//empleadosByProyecto();
		//asignarEmpleadosAProyecto();
		margenActualProyecto();
		
		/*Empleado [] empl = {  edao.buscarUno(124),
							  edao.buscarUno(123)*/
		
		 /*List<ProyectoConEmpleado> empleados = new ArrayList<>();
	        
	        Empleado empleado1 = new Empleado(1, "Juan", 2000.0);
	        Empleado empleado2 = new Empleado(2, "Maria", 2500.0);
	        
	        listaEmpleados.add(empleado1);
	        listaEmpleados.add(empleado2);*/
		
		//};
				
		
	}
	
	
	public static void costeActualDeProyecto() {
		
		System.out.println("Coste Actual");
		
		System.out.println(pedao.costeActualDeProyecto("FOR2020001"));
		
		
	}

	public static void empleadosByProyecto() {
		
		System.out.println(pedao.empleadosByProyecto("FOR2020001"));
			
			
		}
	
	public static void asignarEmpleadosAProyecto() {
		
		//System.out.println(pedao.asignarEmpleadosAProyecto(empl[1]));
	}
	
	public static void margenActualProyecto() {
		
		
		System.out.println(pedao.margenActualProyecto("FOR2020001"));
	
	}
	
		/*ProyectoConEmpleadoDao pedao = new ProyectoConEmpleadoDaoImplMy8Jpa();
		System.out.println(pedao.costeActualDeProyecto("FOR2020001"));*/

	}


