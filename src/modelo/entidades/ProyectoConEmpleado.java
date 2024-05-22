package modelo.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


/**
 * The persistent class for the proyecto_con_empleados database table.
 * 
 */
@Entity
@Table(name="proyecto_con_empleados")
@NamedQuery(name="ProyectoConEmpleado.findAll", query="SELECT p FROM ProyectoConEmpleado p")
public class ProyectoConEmpleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="numero_orden")
	private int numeroOrden;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_incorporacion")
	private Date fechaIncorporacion;

	@Column(name="horas_asignadas")
	private int horasAsignadas;

	//uni-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="id_empl")
	private Empleado empleado;

	//uni-directional many-to-one association to Proyecto
	@ManyToOne
	@JoinColumn(name="id_proyecto")
	private Proyecto proyecto;

	public ProyectoConEmpleado() {
	}

	public int getNumeroOrden() {
		return this.numeroOrden;
	}

	public void setNumeroOrden(int numeroOrden) {
		this.numeroOrden = numeroOrden;
	}

	public Date getFechaIncorporacion() {
		return this.fechaIncorporacion;
	}

	public void setFechaIncorporacion(Date fechaIncorporacion) {
		this.fechaIncorporacion = fechaIncorporacion;
	}

	public int getHorasAsignadas() {
		return this.horasAsignadas;
	}

	public void setHorasAsignadas(int horasAsignadas) {
		this.horasAsignadas = horasAsignadas;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Proyecto getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}


	public ProyectoConEmpleado(int numeroOrden, Date fechaIncorporacion, int horasAsignadas, Empleado empleado,
			Proyecto proyecto) {
		super();
		this.numeroOrden = numeroOrden;
		this.fechaIncorporacion = fechaIncorporacion;
		this.horasAsignadas = horasAsignadas;
		this.empleado = empleado;
		this.proyecto = proyecto;
	}
	
	
	@Override
	public String toString() {
		return "ProyectoConEmpleado [numeroOrden=" + numeroOrden + ", fechaIncorporacion=" + fechaIncorporacion
				+ ", horasAsignadas=" + horasAsignadas + ", empleado=" + empleado + ", proyecto=" + proyecto + "]";
	}
	
	

	
	   @Override
	public int hashCode() {
		return Objects.hash(empleado);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof ProyectoConEmpleado))
			return false;
		ProyectoConEmpleado other = (ProyectoConEmpleado) obj;
		return Objects.equals(empleado, other.empleado);
	}
	//-------------------------------------------------------------
	public double costeHorasAsignadas(double precioHora) {
	        return horasAsignadas * empleado.getPerfil().getTasaStandard().doubleValue();
	    }
        // e preciofechaincio - frechaFinreal
    
	
	
}