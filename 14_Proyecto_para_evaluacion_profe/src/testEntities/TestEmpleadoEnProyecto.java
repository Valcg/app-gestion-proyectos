package testEntities;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import modelo.entidades.Cliente;
import modelo.entidades.Departamento;
import modelo.entidades.Empleado;
import modelo.entidades.Perfil;
import modelo.entidades.Proyecto;
import modelo.entidades.ProyectoConEmpleado;

public class TestEmpleadoEnProyecto {
	public static void main(String[] args) throws ParseException {
		

		
		Cliente cli = new Cliente();
		cli.setApellidos("lola");
		cli.setCif("4ttttttty");
		cli.setDomicilio("lo que sea");
		cli.setFacturacionAnual(null);
		cli.setNombre("lola");
		cli.setNumeroEmpleados(0);
		
		
		
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
		
		Proyecto pro = new Proyecto();
		pro.setDescripcion(null);
		pro.setFechaInicio(null);
		pro.setCosteReal(BigDecimal.valueOf(20));
		pro.setCostesPrevisto(BigDecimal.valueOf(50));
		pro.setEstado(null);
		pro.setEmpleado(empl);
		pro.setCliente(cli);
		pro.setVentaPrevisto(BigDecimal.valueOf(100));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		pro.setFechaFinReal(sdf.parse( "2024-02-25") );
		
		pro.setFechaFinPrevisto(sdf.parse("2024-02-20"));
		
		
		
		
		ProyectoConEmpleado proyEmpl =  new ProyectoConEmpleado();
		proyEmpl.setHorasAsignadas(30);
		proyEmpl.setFechaIncorporacion(sdf.parse( "2024-02-25"));
		proyEmpl.setEmpleado(empl);
		proyEmpl.setProyecto(pro);
		
		
		System.out.println("horas : " + proyEmpl.costeHorasAsignadas());
		
	}
	

	/*		Cliente cli = new Cliente();
		cli.setApellidos("lola");
		cli.setCif("4ttttttty");
		cli.setDomicilio("lo que sea");
		cli.setFacturacionAnual(null);
		cli.setNombre("lola");
		cli.setNumeroEmpleados(0);
		
	
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
		
		
		
		
		Proyecto pro = new Proyecto();
		pro.setDescripcion(null);
		pro.setFechaInicio(null);
		pro.setCosteReal(BigDecimal.valueOf(20));
		pro.setCostesPrevisto(BigDecimal.valueOf(50));
		pro.setEstado(null);
		pro.setEmpleado(empl);
		pro.setCliente(cli);
		pro.setVentaPrevisto(BigDecimal.valueOf(100));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		pro.setFechaFinReal(sdf.parse( "2024-02-25") );
		
		pro.setFechaFinPrevisto(sdf.parse("2024-02-20"));;*/
	
	

	
	

}
