package test.daos;

import modelo.dao.DepartamentoDao;
import modelo.dao.DepartamentoDaoImplMy8Jpa;
import modelo.entidades.Departamento;

public class TestDepartamentoDao {

	private static DepartamentoDao ddao;
	 static {
		 
		 ddao= new DepartamentoDaoImplMy8Jpa();
		 
		 
	 }
	 
	 public static void main(String[] args) {	
			uno();
			todos();
			alta();
		//	eliminar();
		}
/*
	private static void eliminar() {
		Departamento dep = new Departamento(50,"Mantenimiento","Barcelona");
		System.out.print("ELIMINAR----------------------------");
	System.out.println(eliminar.ddao.);
	}*/

	private static void alta() {
		// TODO Auto-generated method stub
		
	}

	private static void todos() {
		// TODO Auto-generated method stub
		
	}

	private static void uno() {
		// TODO Auto-generated method stub
		
	}
		
	
}
