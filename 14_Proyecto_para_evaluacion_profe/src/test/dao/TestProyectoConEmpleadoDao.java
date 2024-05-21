package test.dao;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImplMy8Jpa;
import modelo.dao.ProyectoConEmpleadoDao;
import modelo.dao.ProyectoConEmpleadoDaoImplMy8Jpa;
import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8Jpa;
import modelo.entidades.Empleado;
import modelo.entidades.Proyecto;
import modelo.entidades.ProyectoConEmpleado;



public class TestProyectoConEmpleadoDao {
	
	private static ProyectoConEmpleadoDao pedao ;
	private static EmpleadoDao edao;
	private static ProyectoDao pdao;
	
	static {
		pedao = new ProyectoConEmpleadoDaoImplMy8Jpa();
		edao = new EmpleadoDaoImplMy8Jpa();
		pdao = new ProyectoDaoImplMy8Jpa();
		
	}
	
	

	public static void main(String[] args) throws ParseException {
		
		//costeActualDeProyecto();
		//empleadosByProyecto();
		//asignarEmpleadosAProyecto();
		//margenActualProyecto();
		buscarUno();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	 
		Proyecto proyecto1=  pdao.buscarUno("bd2024004");
		Empleado empl1 = edao.buscarUno(118);
		Empleado empl2 = edao.buscarUno(119);
		Empleado empl3 = edao.buscarUno(120);
		 
		
		List<ProyectoConEmpleado> empleados = new ArrayList<>();
		 
		ProyectoConEmpleado empleado1 = new ProyectoConEmpleado();
		empleado1.setEmpleado(empl1);
		empleado1.setProyecto(proyecto1);
		empleado1.setFechaIncorporacion(sdf.parse("2022-08-16"));
		empleado1.setHorasAsignadas(125);
		
		
		
		ProyectoConEmpleado empleado2 = new ProyectoConEmpleado();
		
		empleado2.setEmpleado(empl2);
		empleado2.setProyecto(proyecto1);
		empleado2.setFechaIncorporacion(sdf.parse("2022-08-16"));
		empleado2.setHorasAsignadas(130);
		
		
		
		ProyectoConEmpleado empleado3 = new ProyectoConEmpleado();
		empleado3.setEmpleado(empl3);
		empleado3.setProyecto(proyecto1);
		empleado3.setFechaIncorporacion(sdf.parse("2022-08-16"));
		empleado3.setHorasAsignadas(120);
		
	        
		 empleados.add(empleado1);
		 empleados.add(empleado2);
		 empleados.add(empleado3);
		asignarEmpleadosAProyecto(empleados);
		
	}
	
	
	public static void costeActualDeProyecto() {
		
		System.out.println("Coste Actual");
		
		System.out.println(pedao.costeActualDeProyecto("FOR2020001"));
		
		
	}

	public static void empleadosByProyecto() {
		
		System.out.println(pedao.empleadosByProyecto("FOR2020001"));
			
			
		}
	
	
	
	public static void asignarEmpleadosAProyecto(List<ProyectoConEmpleado> empleados) {
		
		System.out.println(pedao.asignarEmpleadosAProyecto(empleados));
	}
	
	public static void margenActualProyecto() {
		
		
		System.out.println(pedao.margenActualProyecto("FOR2020001"));
	
	}
	
	public static void buscarUno() {
		
		
		System.out.println(pedao.buscarUno(2));
	
	}
	



	}


