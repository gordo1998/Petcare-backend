package petcare.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 * The persistent class for the dueño database table.
 * 
 */
@Entity
@NamedQuery(name="Dueño.findAll", query="SELECT d FROM Dueño d")
public class Dueño implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDueño;

	private String descripcion;

	//bi-directional many-to-one association to Cuenta
	@JsonBackReference(value = "user_dueños")
	@ManyToOne
	@JoinColumn(name="cuentaDueño")
	private Cuenta cuenta;

	//bi-directional many-to-one association to Reserva
	@JsonManagedReference
	@OneToMany(mappedBy="dueño")
	private List<Reserva> reservas;

	public Dueño() {
	}

	public int getIdDueño() {
		return this.idDueño;
	}

	public void setIdDueño(int idDueño) {
		this.idDueño = idDueño;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Cuenta getCuenta() {
		return this.cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Reserva addReserva(Reserva reserva) {
		getReservas().add(reserva);
		reserva.setDueño(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setDueño(null);

		return reserva;
	}

}