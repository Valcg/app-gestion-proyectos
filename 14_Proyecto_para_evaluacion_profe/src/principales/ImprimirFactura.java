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
import modelo.dao.ProductoDao;
import modelo.dao.ProductoDaoImplMy8Jpa;
import modelo.dao.ProyectoConEmpleadoDao;
import modelo.dao.ProyectoConEmpleadoDaoImplMy8Jpa;
import modelo.dao.ProyectoConProductoDao;
import modelo.dao.ProyectoConProductoDaoImplMy8Jpa;
import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8Jpa;
import modelo.entidades.Factura;

public class ImprimirFactura {
	
	private static FacturaDao fdao;
	private static ClienteDao cdao;
	private static ProyectoDao pdao;
	private static EmpleadoDao edao;
	private static ProductoDao prddao;
	private static ProyectoConEmpleadoDao proEmplDao;
	private static ProyectoConProductoDao propDao;
	
	
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	


	static {
		
		fdao = new FacturaDaoImplMy8Jpa();
		cdao = new ClienteDaoImplMy8Jpa();
		pdao = new ProyectoDaoImplMy8Jpa();
		edao = new EmpleadoDaoImplMy8Jpa();
		prddao = new ProductoDaoImplMy8Jpa();
		proEmplDao= new ProyectoConEmpleadoDaoImplMy8Jpa();
		propDao = new ProyectoConProductoDaoImplMy8Jpa();
		
	}
	
	
	public static void main(String[] args) throws ParseException {
		
		
		
		//CrearLaFilaDeLaFacturaNueva();
		ImprimirLosDatosDeLaFactura();
		
	}
	
	public static void CrearLaFilaDeLaFacturaNueva() throws ParseException {
		Factura factura = new Factura();
		factura.setDescripcion("creacion de base de datos para materiales");
		factura.setIdFactura("BD1001");
		factura.setProyecto(pdao.buscarUno("bd2024004"));
		factura.setFechaFactura(sdf.parse("2023-03-16"));
		
		System.out.println(fdao.alta(factura));
		

		
	}
	
	
	public static void ImprimirLosDatosDeLaFactura() {
		
		System.out.println("DATOS DE LA FACTURA");
		System.out.println("codigo de factura: " + fdao.buscarUno("BD1001").getIdFactura());
		System.out.println("Descripción : " + fdao.buscarUno("BD1001").getDescripcion());
		System.out.println("fecha factura : " + fdao.buscarUno("BD1001").getFechaFactura());
		
		System.out.println("--------------------------------------------------------------");
		
		System.out.println("DATOS DEL PROYECTO");
		System.out.println("id de proyecto : " + fdao.buscarUno("BD1001").getProyecto().getIdProyecto());
		System.out.println("descripcion proyecto : " + fdao.buscarUno("BD1001").getProyecto().getDescripcion());
		System.out.println("fecha fin real : " + fdao.buscarUno("BD1001").getProyecto().getFechaFinReal());
		System.out.println("fecha inicio : " + fdao.buscarUno("BD1001").getProyecto().getFechaInicio());
		
		System.out.println("--------------------------------------------------------------");
		
		System.out.println("DATOS DEL CLIENTE");
		
		System.out.println("nombre del cliente : " + fdao.buscarUno("BD1001").getProyecto().getCliente().getNombre());
		System.out.println("dirección : " + fdao.buscarUno("BD1001").getProyecto().getCliente().getDomicilio());
		
		System.out.println("--------------------------------------------------------------");
		
		System.out.println("DETALLE DE RECURSOS HUMANOS");
		
		System.out.println("--------------------------------------------------------------");
		
		System.out.println("lISTA DE EMPLEADOS");
		
		System.out.println("--------------------------------------------------------------");
		
		System.out.println("Empleados : " + proEmplDao.empleadosByProyecto("bd2024004"));
		

		
		//System.out.println("total de horas :" + proEmplDao.horasAsignadasAProyecto("bd2024004"));
		//System.out.println("total de precio :" + proEmplDao.costeActualDeProyecto("bd2024004"));
		
		
		System.out.println("--------------------------------------------------------------");
		
		System.out.println("lISTA DE PRODUCTOS");
		
		System.out.println("--------------------------------------------------------------");
		
		
		System.out.println(propDao.productosByProyecto("bd2024004"));
		
		
		System.out.println("DETALLE DEL IMPORTE");
		
		System.out.println("importe de venta: " + fdao.buscarUno("BD1001").getProyecto().getVentaPrevisto());
		System.out.println("total facturado : " + fdao.buscarUno("BD1001").getProyecto().margenReal());
		// tomasin no entendi como sacar el total facturado yo creo que es el mismo importe de venta :)
		
		
	}
		 
		}
	


