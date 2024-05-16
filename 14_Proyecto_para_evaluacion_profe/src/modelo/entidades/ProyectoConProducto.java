package modelo.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the proyecto_con_productos database table.
 * 
 */
@Entity
@Table(name="proyecto_con_productos")
@NamedQuery(name="ProyectoConProducto.findAll", query="SELECT p FROM ProyectoConProducto p")
public class ProyectoConProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="num_orden")
	private int numOrden;

	private int cantidad;

	@Column(name="precio_asignado")
	private int precioAsignado;

	//uni-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="id_producto")
	private Producto producto;

	//uni-directional many-to-one association to Proyecto
	@ManyToOne
	@JoinColumn(name="id_proyecto")
	private Proyecto proyecto;

	public ProyectoConProducto() {
	}

	public int getNumOrden() {
		return this.numOrden;
	}

	public void setNumOrden(int numOrden) {
		this.numOrden = numOrden;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getPrecioAsignado() {
		return this.precioAsignado;
	}

	public void setPrecioAsignado(int precioAsignado) {
		this.precioAsignado = precioAsignado;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Proyecto getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	@Override
	public String toString() {
		return "ProyectoConProducto [numOrden=" + numOrden + ", cantidad=" + cantidad + ", precioAsignado="
				+ precioAsignado + ", producto=" + producto + ", proyecto=" + proyecto + "]";
	}
	
	

	public ProyectoConProducto(int numOrden, int cantidad, int precioAsignado, Producto producto, Proyecto proyecto) {
		super();
		this.numOrden = numOrden;
		this.cantidad = cantidad;
		this.precioAsignado = precioAsignado;
		this.producto = producto;
		this.proyecto = proyecto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numOrden;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof ProyectoConProducto))
			return false;
		ProyectoConProducto other = (ProyectoConProducto) obj;
		if (numOrden != other.numOrden)
			return false;
		return true;
	}
	
	

}