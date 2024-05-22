package modelo.dao;

import java.util.List;

import modelo.entidades.Proyecto;

public interface ProyectoDao  extends  IntGenericoCrud <String,Proyecto> {

	

	List<Proyecto> proyectosByEstado(String estado);
	List<Proyecto> proyectosByCliente(String cif);
	List<Proyecto> proyectosByJefeProyectoAndByEstado(int jefeProyecto,String estado);
	
	
	Double importesVentaProyectosTerminados();
	
	Double margenBrutoProyectosTerminados(); //  Diferencia suma Importes venta y gastos reales.
	
	int diasATerminoProyectoActivo(String codigoProyecto);
	
}
