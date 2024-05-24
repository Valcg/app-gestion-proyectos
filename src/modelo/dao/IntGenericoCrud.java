package modelo.dao;

import java.util.List;

public interface IntGenericoCrud<K,T> {
	
	boolean alta(T obj);
	T eliminar(K clave);
	T buscarUno(K clave);
	List<T> buscarTodos();
//k ES LA CLAVE o ID , Y EL T EL TIPO DE CLASE
}
