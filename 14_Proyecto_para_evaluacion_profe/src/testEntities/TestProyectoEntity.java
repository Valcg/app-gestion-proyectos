package testEntities;

import java.math.BigDecimal;
import java.util.Date;

import modelo.entidades.Cliente;
import modelo.entidades.Departamento;
import modelo.entidades.Empleado;
import modelo.entidades.Perfil;
import modelo.entidades.Proyecto;
import principales.GestionClientes;



public class TestProyectoEntity {
	
public static void main(String[] args) {
		
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
		pro.setFechaFinReal(new Date(2020-01-15));
		pro.setFechaFinPrevisto(new Date(2020-02-20));
		pro.setCosteReal(BigDecimal.valueOf(7000));
		pro.setCostesPrevisto(BigDecimal.valueOf(3000));
		pro.setEstado(null);
		pro.setEmpleado(empl);
		pro.setCliente(cli);
		pro.setVentaPrevisto(BigDecimal.valueOf(8000));
	
	
		
		
		
		System.out.println("diferencia fin : " + pro.diferenciaFinPrevistoReal());
		System.out.println("dif gastos : " + pro.diferenciaGastos());
		System.out.println("margen previsto : " + pro.margenPrevisto());
		System.out.println("margen real : " + pro.margenReal());
	
		
	}
	

}
