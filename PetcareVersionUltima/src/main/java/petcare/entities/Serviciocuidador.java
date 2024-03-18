package petcare.entities;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the serviciocuidador database table.
 * 
 */
@Entity
@NamedQuery(name="Serviciocuidador.findAll", query="SELECT s FROM Serviciocuidador s")
public class Serviciocuidador implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ServiciocuidadorPK id;

	//bi-directional many-to-one association to Cuidador
	@ManyToOne
	@JoinColumn(name="cuidadorSC")
	private Cuidador cuidador;

	//bi-directional many-to-one association to Servicio
	@ManyToOne
	@JoinColumn(name="servicioSC")
	private Servicio servicio;

	public Serviciocuidador() {
	}

	public ServiciocuidadorPK getId() {
		return this.id;
	}

	public void setId(ServiciocuidadorPK id) {
		this.id = id;
	}

	public Cuidador getCuidador() {
		return this.cuidador;
	}

	public void setCuidador(Cuidador cuidador) {
		this.cuidador = cuidador;
	}

	public Servicio getServicio() {
		return this.servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

}