package petcare.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the cuidador database table.
 * 
 */
@Entity
@NamedQuery(name="Cuidador.findAll", query="SELECT c FROM Cuidador c")
public class Cuidador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCuidador;

	@Lob
	private String descripcion;

	//bi-directional many-to-one association to Cuenta
	@ManyToOne
	@JoinColumn(name="cuentaCuidador")
	private Cuenta cuenta;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="cuidador")
	private List<Reserva> reservas;

	//bi-directional many-to-one association to Serviciocuidador
	@OneToMany(mappedBy="cuidador")
	private List<Serviciocuidador> serviciocuidadors;

	public Cuidador() {
	}

	public int getIdCuidador() {
		return this.idCuidador;
	}

	public void setIdCuidador(int idCuidador) {
		this.idCuidador = idCuidador;
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
		reserva.setCuidador(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setCuidador(null);

		return reserva;
	}

	public List<Serviciocuidador> getServiciocuidadors() {
		return this.serviciocuidadors;
	}

	public void setServiciocuidadors(List<Serviciocuidador> serviciocuidadors) {
		this.serviciocuidadors = serviciocuidadors;
	}

	public Serviciocuidador addServiciocuidador(Serviciocuidador serviciocuidador) {
		getServiciocuidadors().add(serviciocuidador);
		serviciocuidador.setCuidador(this);

		return serviciocuidador;
	}

	public Serviciocuidador removeServiciocuidador(Serviciocuidador serviciocuidador) {
		getServiciocuidadors().remove(serviciocuidador);
		serviciocuidador.setCuidador(null);

		return serviciocuidador;
	}

}