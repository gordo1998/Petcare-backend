package petcare.entities;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the reservas database table.
 * 
 */
@Entity
@Table(name="reservas")
@NamedQuery(name="Reserva.findAll", query="SELECT r FROM Reserva r")
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idReserva;

	//bi-directional many-to-one association to Cuidador
	@ManyToOne
	@JoinColumn(name="cuidadorR")
	private Cuidador cuidador;

	//bi-directional many-to-one association to Dueño
	@ManyToOne
	@JoinColumn(name="duenyoR")
	private Dueño dueño;

	public Reserva() {
	}

	public int getIdReserva() {
		return this.idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public Cuidador getCuidador() {
		return this.cuidador;
	}

	public void setCuidador(Cuidador cuidador) {
		this.cuidador = cuidador;
	}

	public Dueño getDueño() {
		return this.dueño;
	}

	public void setDueño(Dueño dueño) {
		this.dueño = dueño;
	}

}