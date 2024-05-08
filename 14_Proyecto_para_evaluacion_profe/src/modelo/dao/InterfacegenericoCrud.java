package modelo.dao;

import java.util.List;
// k campos clave
// t elemento


public interface InterfacegenericoCrud<K, T> {
	boolean alta(T obj);
	T eliminar(K clave);
	T buscarUno(K clave);
	List<T>buscarTodos();

}
