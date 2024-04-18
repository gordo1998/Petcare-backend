package petcare.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the raza database table.
 * 
 */
@Entity
@NamedQuery(name="Raza.findAll", query="SELECT r FROM Raza r")
public class Raza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRaza;

	private String nombre;

	//bi-directional many-to-one association to Mascota
	@OneToMany(mappedBy="raza")
	private List<Mascota> mascotas;

	//bi-directional many-to-one association to Animal
	@ManyToOne
	@JoinColumn(name="animalRaza")
	private Animal animal;

	public Raza() {
	}

	public int getIdRaza() {
		return this.idRaza;
	}

	public void setIdRaza(int idRaza) {
		this.idRaza = idRaza;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Mascota> getMascotas() {
		return this.mascotas;
	}

	public void setMascotas(List<Mascota> mascotas) {
		this.mascotas = mascotas;
	}

	public Mascota addMascota(Mascota mascota) {
		getMascotas().add(mascota);
		mascota.setRaza(this);

		return mascota;
	}

	public Mascota removeMascota(Mascota mascota) {
		getMascotas().remove(mascota);
		mascota.setRaza(null);

		return mascota;
	}

	public Animal getAnimal() {
		return this.animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

}