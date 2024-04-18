package petcare.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


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

	private int accesFirstTime;

	private String descripcion;

	private String descripcionCorta;

	//bi-directional many-to-one association to Cuenta
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="cuentaCuidador")
	private Cuenta cuenta;

	//bi-directional many-to-one association to Reserva
	@JsonManagedReference
	@OneToMany(mappedBy="cuidador")
	private List<Reserva> reservas;

	//bi-directional many-to-many association to Servicio
	@JsonManagedReference
	@ManyToMany(mappedBy="cuidadors")
	private List<Servicio> servicios;

	//bi-directional many-to-many association to Animal
	@ManyToMany
	@JoinTable(
		name="cuidadoranimal"
		, joinColumns={
			@JoinColumn(name="idCuidadorC")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idAnimalC")
			}
		)
	private List<Animal> animals;

	//bi-directional many-to-many association to Dueño
	@ManyToMany(mappedBy="cuidadors")
	private List<Dueño> dueños;

	public Cuidador() {
	}

	public int getIdCuidador() {
		return this.idCuidador;
	}

	public void setIdCuidador(int idCuidador) {
		this.idCuidador = idCuidador;
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
		reserva.setCuidador(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setCuidador(null);

		return reserva;
	}

	public List<Servicio> getServicios() {
		return this.servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public List<Animal> getAnimals() {
		return this.animals;
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}

	public List<Dueño> getDueños() {
		return this.dueños;
	}

	public void setDueños(List<Dueño> dueños) {
		this.dueños = dueños;
	}

}