package modelo.dao;

import java.math.BigDecimal;
import java.util.List;

import modelo.entidades.Empleado;

public interface EmpleadoDao extends InterfacegenericoCrud<String,Empleado> {
	

	 List<Empleado>empleadosByDepartamento(int idDepar);
	 List<Empleado>empleadosBySexo(char sexo);
	 List<Empleado>empleadosByApellido(String subcadena);
	 BigDecimal salarioTotal();
	 BigDecimal salarioTotal(int idDepar);
	 
	
}
