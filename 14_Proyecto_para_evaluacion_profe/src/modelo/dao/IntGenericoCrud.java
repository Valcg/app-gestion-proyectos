package modelo.dao;

import java.util.List;

public interface IntGenericoCrud<K,T> {
	
	boolean alta(T obj);
	T eliminar(String clave);
	T buscarUno(K clave);
	List<T> buscarTodos();

}
