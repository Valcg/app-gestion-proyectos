package testEntities;

import java.math.BigDecimal;
import modelo.entidades.Departamento;
import modelo.entidades.Empleado;
import modelo.entidades.Perfil;

public class TestEmpleadoEntity {
public static void main(String[] args) {
		

		Perfil perfil1 = new Perfil();
		perfil1.setIdPerfil(5);
		perfil1.setNombre("cocina");
		perfil1.setTasaStandard(BigDecimal.valueOf(300));
		
		Departamento dep1 = new Departamento();
		dep1.setNombre("consultoria");
		dep1.setDireccion("madrid");
	
		Empleado empl = new Empleado();
		empl.setNombre("petra");
		empl.setApellidos("pera");
		empl.setGenero("M");
		empl.setPassword("root");
		empl.setSalario(BigDecimal.valueOf(3000));
		empl.setPerfil(perfil1);
		empl.setDepartamento(dep1);
		
		System.out.println("nombre completo empleado : " + empl.nombreCompleto());
		System.out.println("SALARIO : " + empl.salarioBruto() );
		System.out.println("SALARIO MENSUAL : " + empl.salarioMensual(12) );
		System.out.println("genero : " + empl.literalSexo());
		System.err.println("email: " + empl.obtenerEmail());
		System.out.println("Departamento : " +  empl.getDepartamento());
		
	}
	
	
}
