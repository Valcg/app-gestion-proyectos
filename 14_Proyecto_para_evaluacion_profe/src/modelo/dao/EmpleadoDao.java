package modelo.dao;


import java.util.List;

import modelo.entidades.Empleado;

public interface EmpleadoDao extends InterfacegenericoCrud<Integer,Empleado> {
	

	 List<Empleado>empleadosByDepartamento(int idDepar);
	 List<Empleado>empleadosBySexo(String sexo);
	 List<Empleado>empleadosByApellido(String subcadena);
	 double salarioTotal();
	 double salarioTotal(int idDepar);
	
	 
	
}
