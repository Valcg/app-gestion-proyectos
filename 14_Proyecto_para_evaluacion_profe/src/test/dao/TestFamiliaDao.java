package test.dao;

import modelo.dao.FamiliaDao;
import modelo.dao.FamiliaDaoImplMy8Jpa;
import modelo.entidades.Familia;

public class TestFamiliaDao {
	
	private static FamiliaDao fadao;
	
	static {
		
		fadao = new FamiliaDaoImplMy8Jpa();
	}
	
	public static void main(String[] args) {
		alta();
	}
	
	public static void alta() {
		
		Familia familia1 = new Familia();
		familia1.setDescripcion("");
		
		System.out.println("alta : " +  fadao.alta(familia1));
		
		
	}

}
