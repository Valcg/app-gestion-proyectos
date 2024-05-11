package modelo.dao;

import java.util.List;

import modelo.entidades.Cliente;


public class ClienteDaoImplMy8Jpa extends abstractDaoImplMy8Jpa 

implements ClienteDao{
	
	public ClienteDaoImplMy8Jpa() {
		super();
	}


	@Override
	public boolean alta(Cliente obj) {
		
		try {
			tx.begin();
			em.persist(obj);// insert
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();// capturamos el error
			return false;
		}
	}

	@Override
	public Cliente eliminar(String clave) {
		try {
			//variable
			Cliente cliente  = buscarUno(clave);
			
			if(cliente  != null) {
				// que arranque la trnasaccio para poder hacer el commit 
				tx.begin();
					em.remove(cliente);
				tx.commit();
				return cliente;
			}else {
				return null;
			}
			
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
// importe de venta de proyecto es la venta prevista
//no hay jefe de departamento 

	

