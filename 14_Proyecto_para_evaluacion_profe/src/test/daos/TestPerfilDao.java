package test.daos;

import java.math.BigDecimal;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8JPA;
import modelo.dao.DepartamentoDao;
import modelo.dao.DepartamentoDaoImplMy8JPA;
import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImplMy8JPA;
import modelo.dao.PerfilDao;
import modelo.dao.PerfilDaoImplMy8JPA;
import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8JPA;
import modelo.entidades.Perfil;

public class TestPerfilDao {

	private static ProyectoDao pdao;
	private static ClienteDao cdao;
	private static EmpleadoDao edao;
	private static PerfilDao pfdao;
	
	static {
		pdao = new ProyectoDaoImplMy8JPA();
		cdao = new ClienteDaoImplMy8JPA();
		edao = new EmpleadoDaoImplMy8JPA();
		pfdao = new PerfilDaoImplMy8JPA();
	}
	
	public static void main(String[] args) {
		// alta();
		// eliminar();
		// buscarUno();
		buscarTodos();
	}

	private static void buscarTodos() {
		pfdao.buscarTodos().forEach(System.out::println);
	}

	private static void buscarUno() {
		System.out.println(pfdao.buscarUno(2));
	}

	private static void eliminar() {
		System.out.println(pfdao.eliminar(5));		
	}

	private static void alta() {
		Perfil perfil1 = new Perfil();
		perfil1.setNombre("Jefe de Marketing");
		perfil1.setTasaStandard(BigDecimal.valueOf(300.00));
		
		Perfil perfil2 = new Perfil();
		perfil2.setNombre("Desarrollador de Software");
		perfil2.setTasaStandard(BigDecimal.valueOf(400.00));
		
		Perfil perfil3 = new Perfil();
		perfil3.setNombre("Supervisor de Producción");
		perfil3.setTasaStandard(BigDecimal.valueOf(250.00));
		
		System.out.println(pfdao.alta(perfil1));
		// System.out.println(pfdao.alta(perfil2));
		// System.out.println(pfdao.alta(perfil3));
	}
	
	
}
