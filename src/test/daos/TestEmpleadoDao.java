package test.daos;

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
import modelo.entidades.ProyectoConEmpleado;

public class TestEmpleadoDao {
	
	private static EmpleadoDao edao;
	private static DepartamentoDao dedao;
	private static PerfilDao pdao;
	
	
	static {
		
	edao = new EmpleadoDaoImplMy8Jpa();	
	dedao = new DepartamentoDaoImplMy8Jpa(); // Departamento DaoImplMy8Jpa
	pdao = new PerfilDaoImplMy8Jpa(); // PerfilDaoImplMy8jpa
			
	}
	
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public static void main(String[] args) throws ParseException { // USAMOS TAMBIEN thorws parse- para que funcionen
		
		eliminarEmpleado();
		mostrarTodos();		
		buscarUno();
		
		alta();	
	}

	private static void buscarUno() {
		System.out.println("------------------BUSCAR UNO");
		System.out.println(edao.buscarUno(117));	
		
	}

	private static void alta() throws ParseException {
		System.out.println("---------------------------------ALTA");
		Empleado  emp = new Empleado();

		//emp.setIdEmpl(200);
		emp.setNombre("Emilio");
		emp.setApellidos("Elpozo");
		emp.setGenero("H");
		emp.setEmail("emilio@gmail.com");
		emp.setPassword("emilio");
		emp.setSalario(BigDecimal.valueOf(50000)); // PARA NUM CON BIG DECIMAL
		emp.setFechaIngreso(sdf.parse("1990-02-22"));
		emp.setFechaNacimiento(sdf.parse("1990-02-22"));
		emp.setPerfil(pdao.buscarUno(1)); // BUSCAR UNO 
		emp.setDepartamento(dedao.buscarUno(20)); // BUSCAR UNO
		emp.setProyectos(null);		
		
		System.out.println(edao.alta(emp));
		//	todos();// LLAMAMOS A BUSCARODOS 
		// ProyectoConEmpleado pce = new ProyectoConEmpleado();
		// pce.setEmpleado(edao.buscarUno(118));	 
	}
	private static void mostrarTodos() { // TODOSS
		System.out.println("---------------------------------BUSCAR TODOS");
		edao.buscarTodos().forEach(System.out::println);	
	}
	private static void eliminarEmpleado() {
		System.out.println("---------------------------------ELIMINAR");
		System.out.println("eliminar" + edao.eliminar(120));


}
}