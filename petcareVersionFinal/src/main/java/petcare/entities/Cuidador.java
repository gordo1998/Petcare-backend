package petcare.entities;

import java.io.Serializable;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public Map<String, Map<String, Object>> getServicios() {
		Map<String, Map<String, Object>> mapServicios = new HashMap<>();
		for (Servicio i: this.servicios) {
			Map<String, Object> mapServicio = new HashMap<>();
			mapServicio.put("idServicio", i.getIdServicio());
			mapServicio.put("nombre", i.getNombreServicio());
			mapServicios.put("Servicio " + i.getIdServicio(), mapServicio);
		}
		return mapServicios;
	}

	public void setServicios(List<Integer> servicios) {
		List<Servicio> serv = new ArrayList<>();
		for(Integer s: servicios) {
			Servicio servicio = new Servicio();
			servicio.setIdServicio(s);
			serv.add(servicio);
		}
		this.servicios = serv;
	}

	public Map<String, Map<String, Object>> getAnimals() {
		Map<String, Map<String, Object>> mapAnimales = new HashMap<>();
		int animal = 0;
		for(Animal a: this.animals) {
			Map<String, Object> mapAnimal = new HashMap<>();
			mapAnimal.put("idAnimal", a.getIdAnimal());
			mapAnimal.put("nombre", a.getNombre());
			mapAnimales.put("Animal " + animal, mapAnimal);
			animal++;
		}
		return mapAnimales;
	}

	public void setAnimals(List<Integer> animals) {
		List<Animal> animales = new ArrayList<>();
		for(Integer animal: animals) {
			Animal a = new Animal();
			a.setIdAnimal(animal);
			animales.add(a);
		}
		this.animals = animales;
	}

	public List<Dueño> getDueños() {
		return this.dueños;
	}

	public void setDueños(List<Dueño> dueños) {
		this.dueños = dueños;
	}

}