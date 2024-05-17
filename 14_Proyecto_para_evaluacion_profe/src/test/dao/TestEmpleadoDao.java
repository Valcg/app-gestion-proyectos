package test.dao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import modelo.dao.DepartamentoDao;
import modelo.dao.DepartamentoDaoImplMy8Jpa;
import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImplMy8Jpa;
import modelo.dao.PerfilDao;
import modelo.dao.PerfilDaoImplMy8Jpa;
import modelo.entidades.Empleado;


public class TestEmpleadoDao {

private static EmpleadoDao edao ;
private static PerfilDao pdao ;
private static DepartamentoDao ddao ;
	
	
	static {
		
		edao = new EmpleadoDaoImplMy8Jpa();
		pdao = new PerfilDaoImplMy8Jpa();
		ddao = new DepartamentoDaoImplMy8Jpa();
}
	

	 static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	
	public static void main(String[] args) throws ParseException{
		alta();
		//todos();
		//uno();
		//eliminar();
		//empleadosByDepartamento();
		//empleadosBySexo();
		//empleadosByApellido();
		//salarioTotal();
		//salarioTotalINT();
		
		
}
	
	public static void alta() throws ParseException {
		
		Empleado empl = new Empleado();
		empl.setNombre("Petra");
		empl.setApellidos("Jimenez");
		empl.setGenero("M");
		empl.setFechaIngreso(null);
		empl.setFechaNacimiento(null);
		empl.setEmail(empl.obtenerEmail());
		empl.setPassword("Petra");
		empl.setSalario(BigDecimal.valueOf(3000));
		empl.setPerfil(pdao.buscarUno(4));
		empl.setDepartamento(ddao.buscarUno(10));
		empl.setProyectos(null);
		
		Empleado empl1 = new Empleado();
		empl1.setNombre("Tomas");
		empl1.setApellidos("escudero");
		empl1.setGenero("H");
		empl1.setFechaIngreso(sdf.parse("2020-06-06"));
		empl1.setFechaNacimiento(sdf.parse("1990-01-20"));
		empl1.setEmail(empl1.obtenerEmail());
		empl1.setPassword("Tomas");
		empl1.setSalario(BigDecimal.valueOf(20000));
		empl1.setPerfil(pdao.buscarUno(3));
		empl1.setDepartamento(ddao.buscarUno(20));
		empl1.setProyectos(null);
		
		Empleado empl2 = new Empleado();
		empl2.setNombre("Carolina");
		empl2.setApellidos("rosa");
		empl2.setGenero("M");
		empl2.setFechaIngreso(sdf.parse("2020-08-25"));
		empl2.setFechaNacimiento(sdf.parse("1995-02-05"));
		empl2.setEmail(empl2.obtenerEmail());
		empl2.setPassword("Carolina");
		empl2.setSalario(BigDecimal.valueOf(15000));
		empl2.setPerfil(pdao.buscarUno(1));
		empl2.setDepartamento(ddao.buscarUno(40));
		empl2.setProyectos(null);
			
		 
		System.out.println(edao.alta(empl));
		System.out.println(edao.alta(empl1));
		System.out.println(edao.alta(empl2));
		todos();
		
		
	}
	
	public static void eliminar() {
		
		 
		System.out.println(" eliminando : " + edao.eliminar(121));
		
		
	}

	public static void uno() {
		
		System.out.println("BUSCAR UNO");
		System.out.println(edao.buscarUno(115));
		
	}

	
	public static void todos() {
		
		System.out.println("BUSCAR TODOS");
		
		edao.buscarTodos().forEach(System.out::println);// se bucla por que es una relacion cruzada dentro de empleados hay un proyecto y dentro de proyecto hay un empleado
		
	}
	
		
	public static void empleadosByDepartamento() {
			
			
			System.out.println(edao.empleadosByDepartamento(10));
			
		}
	
	public static void empleadosBySexo() {
		
		System.out.println(edao.empleadosBySexo("M"));
		
	}
	
	
	public static void empleadosByApellido() {
		
		
		System.out.println(edao.empleadosByApellido("Himuro"));
		
	}
	
	public static void salarioTotal() {
		
		
		System.out.println(edao.salarioTotal());
		
	}
	
	public static void salarioTotalINT() {
		
		System.out.println(edao.salarioTotal(10));
	
		
	}
	
	
	
	}

