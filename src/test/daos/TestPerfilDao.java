package test.daos;

import java.math.BigDecimal;

import modelo.dao.PerfilDao;
import modelo.dao.PerfilDaoImplMy8Jpa;
import modelo.entidades.Perfil;

public class TestPerfilDao {
	
	private static PerfilDao pdao;
	
	static {		 
	pdao = new PerfilDaoImplMy8Jpa(); 
	}	
	
	public static void main(String[] args) {
		uno();
		todos();
		alta();
	//	eliminar();	
	}

	private static void eliminar() {
		System.out.println("------------------ELIMINAR");
		//System.out.println("eliminar" + ddao.eliminar(1));		
	}

	private static void alta() {
		System.out.println("------------------ALTA");
		Perfil per = new Perfil();
	//	per.setIdPerfil(6);--------------- NO LO CENESITA 
		per.setNombre("Soporte de Ayuda");
		per.setTasaStandard(BigDecimal.valueOf(300.00));
		
		System.out.println(pdao.alta(per));
		
		todos();
		System.out.println("------------------FIN DE ALTA");
	}

	private static void todos() {
		System.out.println("------------------BUSCAR TODOS");
		pdao.buscarTodos().forEach(System.out::println);
	}

	private static void uno() {
		System.out.println("------------------BUSCAR UNO");
		System.out.println(pdao.buscarUno(2));	
	}
}
