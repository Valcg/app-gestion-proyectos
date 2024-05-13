package modelo.dao;

import java.util.List;

import modelo.entidades.Cliente;

public class ClienteDaoImplMy8JPA extends AbstractDaoImplMy8Jpa implements ClienteDao{
	
	public ClienteDaoImplMy8JPA() {
		super();
	}

	@Override
	public boolean alta(Cliente obj) {
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
	public Cliente eliminar(String clave) {
		try {
			Cliente cliente1 = buscarUno(clave);
			if (cliente1 != null) {
				tx.begin();
					em.remove(cliente1);
				tx.commit();
				return cliente1;
			}else
				return null;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Cliente buscarUno(String clave) {
		return em.find(Cliente.class, clave);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> buscarTodos() {
		jpql = "select c from Cliente c";
		query = em.createQuery(jpql);
		return query.getResultList();
	}

}
