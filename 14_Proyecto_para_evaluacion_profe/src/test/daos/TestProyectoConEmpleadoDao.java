package test.daos;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8JPA;
import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImplMy8JPA;
import modelo.dao.ProyectoConEmpleadoDao;
import modelo.dao.ProyectoConEmpleadoDaoImplMy8JPA;
import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8JPA;
import modelo.entidades.ProyectoConEmpleado;

public class TestProyectoConEmpleadoDao {

	private static ProyectoDao pdao;
	private static ClienteDao cdao;
	private static EmpleadoDao edao; 
	private static ProyectoConEmpleadoDao pcedao;
	
	
	static {
		pdao = new ProyectoDaoImplMy8JPA();
		cdao = new ClienteDaoImplMy8JPA();
		edao = new EmpleadoDaoImplMy8JPA();
		pcedao = new ProyectoConEmpleadoDaoImplMy8JPA();
	}
	
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public static void main(String[] args) throws ParseException{
		alta();
	}

	private static void alta() throws ParseException{
		ProyectoConEmpleado proyectoconempleado1 = new ProyectoConEmpleado();
		proyectoconempleado1.setEmpleado(edao.buscarUno(118));
		proyectoconempleado1.setFechaIncorporacion(sdf.parse("2020-02-15"));
		proyectoconempleado1.setHorasAsignadas(80);
		proyectoconempleado1.setNumeroOrden(5);
		proyectoconempleado1.setProyecto(pdao.buscarUno("FOR2021001"));
		
		System.out.println(pcedao.alta(proyectoconempleado1));
	}
}
