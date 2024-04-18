package petcare.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the mascota database table.
 * 
 */
@Entity
@NamedQuery(name="Mascota.findAll", query="SELECT m FROM Mascota m")
public class Mascota implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMascota;

	@Lob
	private String descEnfermedades;

	@Lob
	private String descSobreMascota;

	private int edad;

	private String nombre;

	private float peso;

	//bi-directional many-to-one association to Alimento
	@ManyToOne
	@JoinColumn(name="alimentoMascota")
	private Alimento alimento;

	//bi-directional many-to-one association to Dueño
	@ManyToOne
	@JoinColumn(name="duenyoMascota")
	private Dueño dueño;

	//bi-directional many-to-one association to Raza
	@ManyToOne
	@JoinColumn(name="razaMascota")
	private Raza raza;

	//bi-directional many-to-many association to Reserva
	@ManyToMany(mappedBy="mascotas")
	private List<Reserva> reservas;

	public Mascota() {
	}

	public int getIdMascota() {
		return this.idMascota;
	}

	public void setIdMascota(int idMascota) {
		this.idMascota = idMascota;
	}

	public String getDescEnfermedades() {
		return this.descEnfermedades;
	}

	public void setDescEnfermedades(String descEnfermedades) {
		this.descEnfermedades = descEnfermedades;
	}

	public String getDescSobreMascota() {
		return this.descSobreMascota;
	}

	public void setDescSobreMascota(String descSobreMascota) {
		this.descSobreMascota = descSobreMascota;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPeso() {
		return this.peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public Alimento getAlimento() {
		return this.alimento;
	}

	public void setAlimento(Alimento alimento) {
		this.alimento = alimento;
	}

	public Dueño getDueño() {
		return this.dueño;
	}

	public void setDueño(Dueño dueño) {
		this.dueño = dueño;
	}

	public Raza getRaza() {
		return this.raza;
	}

	public void setRaza(Raza raza) {
		this.raza = raza;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

}