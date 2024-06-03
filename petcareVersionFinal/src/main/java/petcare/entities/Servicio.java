package petcare.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the servicios database table.
 * 
 */
@Entity
@Table(name="servicios")
@NamedQuery(name="Servicio.findAll", query="SELECT s FROM Servicio s")
public class Servicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idServicio;

	private String nombreServicio;

	//bi-directional many-to-many association to Cuidador
	@ManyToMany
	@JoinTable(
		name="serviciocuidador"
		, joinColumns={
			@JoinColumn(name="idServicioS")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idCuidadorS")
			}
		)
	private List<Cuidador> cuidadors;

	public Servicio() {
	}

	public int getIdServicio() {
		return this.idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public String getNombreServicio() {
		return this.nombreServicio;
	}

	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	public List<Cuidador> getCuidadors() {
		return this.cuidadors;
	}

	public void setCuidadors(List<Cuidador> cuidadors) {
		this.cuidadors = cuidadors;
	}

}