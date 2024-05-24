package modelo.dao;

import java.util.List;

import modelo.entidades.Departamento;
import modelo.entidades.Proyecto;

public class DepartamentoDaoImplMy8JPA extends AbstractDaoImplMy8Jpa implements DepartamentoDao{
	
	public DepartamentoDaoImplMy8JPA() {
		super();
	}

	@Override
	public boolean alta(Departamento obj) {
		try {
			tx.begin();
				em.persist(obj);
			tx.commit();
			return true;
		}catch(Exception e) {
		e.printStackTrace();
			return false;
			
		}
	}

	@Override
	public Departamento eliminar(Integer clave) {
		try {
			Departamento departamento1 = buscarUno(clave);
			if (departamento1 != null) {
				tx.begin();
					em.remove(departamento1);
				tx.commit();
				return departamento1;
			}else
				return null;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Departamento buscarUno(Integer clave) {
		return em.find(Departamento.class,clave);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Departamento> buscarTodos() {
		jpql = "select d from Departamento d";
		query = em.createQuery(jpql);
		return query.getResultList();
	}
	
	

}
