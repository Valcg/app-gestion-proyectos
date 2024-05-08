package modelo.dao;

import java.util.List;

import modelo.entidades.Proyecto;

public class ProyectoConEmpleadoDaoImplMy8Jpa implements ProyectoDao{

	@Override
	public boolean alta(Proyecto obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Proyecto eliminar(String clave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Proyecto buscarUno(String clave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Proyecto> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Proyecto> proyectosByEstado(String estado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Proyecto> proyectosByCliente(String cif) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Proyecto> proyectosByJefeProyectoAndByEstado(int jefeProyecto, String estado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double importesVentaProyectosTerminados() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double margenBrutoProyectosTerminados() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int diasATerminoProyectoActivo(String codigoProyecto) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
