package principales;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8Jpa;
import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImplMy8Jpa;
import modelo.dao.FacturaDao;
import modelo.dao.FacturaDaoImplMy8Jpa;
import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8Jpa;
import modelo.entidades.Factura;

public class ImprimirFactura {
	
	private static FacturaDao fdao;
	private static ClienteDao cdao;
	private static ProyectoDao pdao;
	private static EmpleadoDao edao;
	
	private static Scanner leer;
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	


	static {
		
		fdao = new FacturaDaoImplMy8Jpa();
		cdao = new ClienteDaoImplMy8Jpa();
		pdao = new ProyectoDaoImplMy8Jpa();
		edao = new EmpleadoDaoImplMy8Jpa();
		leer = new Scanner(System.in);
	}
	
	
	public static void main(String[] args) throws ParseException {
		
		
		
		CrearLaFilaDeLaFacturaNueva();
		ImprimirLosDatosDeLaFactura();
		
	}
	
	public static void CrearLaFilaDeLaFacturaNueva() throws ParseException {
		Factura factura = new Factura();
		factura.setDescripcion("creacion de base de datos para materiales");
		factura.setIdFactura("BD1001");
		factura.setProyecto(pdao.buscarUno("bd2024004"));
		factura.setFechaFactura(sdf.parse("2024-02-20"));
		
		System.out.println(fdao.alta(factura));
		
	}
	
	
	public static void ImprimirLosDatosDeLaFactura() {
		
		System.out.println("DATOS DE LA FACTURA");
		System.out.print("codigo de factura:" + fdao.buscarUno("BD1001").getIdFactura());
		System.out.print("Descripción : " + fdao.buscarUno("BD1001").getDescripcion());
		System.out.println("Descripción : " + fdao.buscarUno("BD1001").getFechaFactura());
		
		System.out.println("--------------------------------------------------------------");
		
		System.out.println("DATOS DEL PROYECTO");
		System.out.println("id de proyecto :" + fdao.buscarUno("BD1001").getProyecto().getIdProyecto());
		System.out.println("id de proyecto :" + fdao.buscarUno("BD1001").getProyecto().getDescripcion());
		System.out.println("id de proyecto :" + fdao.buscarUno("BD1001").getProyecto().getFechaFinReal());
		System.out.println("id de proyecto :" + fdao.buscarUno("BD1001").getProyecto().getFechaInicio());
		
		System.out.println("--------------------------------------------------------------");
		
		
		
	}
		 
		}
	


