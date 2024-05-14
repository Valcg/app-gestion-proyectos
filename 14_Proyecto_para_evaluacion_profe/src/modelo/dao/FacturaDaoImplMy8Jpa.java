package modelo.dao;

import java.util.List;

import modelo.entidades.Factura;

public class FacturaDaoImplMy8Jpa  extends abstractDaoImplMy8Jpa implements FacturaDao {

	@Override
	public boolean alta(Factura obj) {
		try {
			tx.begin();
			em.persist(obj);
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Factura eliminar(String clave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Factura buscarUno(String clave) {
		return em.find(Factura.class, clave);
		
	}

	@Override
	public List<Factura> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	
	/* altaFactura(Factura factura): int
- findById(String código): Factura*/
}
