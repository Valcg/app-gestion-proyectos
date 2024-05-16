package modelo.dao;

import java.util.List;


import modelo.entidades.ProyectoConProducto;

public interface ProyectoConProductoDao extends InterfacegenericoCrud<Integer, ProyectoConProducto> {
	
	
	List<ProyectoConProducto>productosByProyecto(String codigoProyecto);
	int asignarProductoAProyecto(List<ProyectoConProducto> producto);

}
