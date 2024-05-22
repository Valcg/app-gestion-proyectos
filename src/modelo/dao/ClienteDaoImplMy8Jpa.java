package modelo.dao;

import java.util.List;

import modelo.entidades.Cliente;



public class ClienteDaoImplMy8Jpa  extends AbstractDaoImplMy8Jpa implements ClienteDao{

	public ClienteDaoImplMy8Jpa(){
		super();
	}
	@Override
	public boolean alta(Cliente obj) {
		
		try {
			tx.begin();
			em.persist(obj);
			tx.commit();
			return true;	// SI SE PERSISTE TRUE
		}catch(Exception e) {
			//TODoo : handle exception
			e.printStackTrace(); // SI NO FALSE
			return false;
			}	
		}
	@Override
	public Cliente eliminar(String clave) {
		try {
			Cliente cliente = buscarUno(clave); // aqui e llega el campo clave
				if (cliente != null) {
					tx.begin(); // que te va a llegar un insert o varios- INSERTARO MODIFICAR--- EMPIEZA - para hacer el commit
						em.merge(cliente);
					tx.commit();
					return cliente;
					//TRUE
				}	else
					return null;
		}
			catch(Exception e) {
				//TODoo : handle exception
				e.printStackTrace(); // SI NO FALSE
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
		 jpql ="select c from Cliente c ";
		 query = em.createQuery(jpql);// ES QUERY
		 return query.getResultList();	
	}
	
}
