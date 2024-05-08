package modelo.dao;

import java.util.List;

import modelo.entidades.Proyecto;

public interface ProyectoDao extends InterfacegenericoCrud<String,Proyecto> {

	List<Proyecto>proyectosByEstado(String estado);
	List<Proyecto>proyectosByCliente(String cif);
	List<Proyecto>proyectosByJefeProyectoAndByEstado(int jefeProyecto,String estado);
	double importesVentaProyectosTerminados();
	double margenBrutoProyectosTerminados(); // Diferencia suma Importes venta y gastos reales.
	int diasATerminoProyectoActivo(String codigoProyecto);//Cuantos días quedan  para terminar el proyecto (diferencia entre fecha_fin_previsto y la fecha de hoy
	
	
	
}
