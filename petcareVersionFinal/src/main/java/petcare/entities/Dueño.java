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

	private int accesFirstTime;

	private String descripcion;

	private String descripcionCorta;

	//bi-directional many-to-one association to Cuenta
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="cuentaDueño")
	private Cuenta cuenta;

	//bi-directional many-to-one association to Reserva
	@JsonManagedReference
	@OneToMany(mappedBy="dueño")
	private List<Reserva> reservas;

	//bi-directional many-to-many association to Cuidador
	@ManyToMany
	@JoinTable(
		name="cuidadorfavorito"
		, joinColumns={
			@JoinColumn(name="idDueñoDelFavorito")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idCuidadorFavorito")
			}
		)
	private List<Cuidador> cuidadors;

	//bi-directional many-to-one association to Mascota
	@JsonManagedReference
	@OneToMany(mappedBy="dueño")
	private List<Mascota> mascotas;

	public Dueño() {
	}

	public int getIdDueño() {
		return this.idDueño;
	}

	public void setIdDueño(int idDueño) {
		this.idDueño = idDueño;
	}

	public int getAccesFirstTime() {
		return this.accesFirstTime;
	}

	public void setAccesFirstTime(int accesFirstTime) {
		this.accesFirstTime = accesFirstTime;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcionCorta() {
		return this.descripcionCorta;
	}

	public void setDescripcionCorta(String descripcionCorta) {
		this.descripcionCorta = descripcionCorta;
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

	public List<Cuidador> getCuidadors() {
		return this.cuidadors;
	}

	public void setCuidadors(List<Cuidador> cuidadors) {
		this.cuidadors = cuidadors;
	}

	public List<Mascota> getMascotas() {
		return this.mascotas;
	}

	public void setMascotas(List<Mascota> mascotas) {
		this.mascotas = mascotas;
	}

	public Mascota addMascota(Mascota mascota) {
		getMascotas().add(mascota);
		mascota.setDueño(this);

		return mascota;
	}

	public Mascota removeMascota(Mascota mascota) {
		getMascotas().remove(mascota);
		mascota.setDueño(null);

		return mascota;
	}

}