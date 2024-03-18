package petcare.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;


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

	//bi-directional many-to-one association to Serviciocuidador
	@JsonManagedReference
	@OneToMany(mappedBy="servicio")
	private List<Serviciocuidador> serviciocuidadors;

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

	public List<Serviciocuidador> getServiciocuidadors() {
		return this.serviciocuidadors;
	}

	public void setServiciocuidadors(List<Serviciocuidador> serviciocuidadors) {
		this.serviciocuidadors = serviciocuidadors;
	}

	public Serviciocuidador addServiciocuidador(Serviciocuidador serviciocuidador) {
		getServiciocuidadors().add(serviciocuidador);
		serviciocuidador.setServicio(this);

		return serviciocuidador;
	}

	public Serviciocuidador removeServiciocuidador(Serviciocuidador serviciocuidador) {
		getServiciocuidadors().remove(serviciocuidador);
		serviciocuidador.setServicio(null);

		return serviciocuidador;
	}

}