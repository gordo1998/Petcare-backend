package petcare.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the animal database table.
 * 
 */
@Entity
@NamedQuery(name="Animal.findAll", query="SELECT a FROM Animal a")
public class Animal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAnimal;

	private String nombre;

	//bi-directional many-to-many association to Cuidador
	@ManyToMany(mappedBy="animals")
	private List<Cuidador> cuidadors;

	//bi-directional many-to-one association to Raza
	@OneToMany(mappedBy="animal")
	private List<Raza> razas;

	public Animal() {
	}

	public int getIdAnimal() {
		return this.idAnimal;
	}

	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Cuidador> getCuidadors() {
		return this.cuidadors;
	}

	public void setCuidadors(List<Cuidador> cuidadors) {
		this.cuidadors = cuidadors;
	}

	public List<Raza> getRazas() {
		return this.razas;
	}

	public void setRazas(List<Raza> razas) {
		this.razas = razas;
	}

	public Raza addRaza(Raza raza) {
		getRazas().add(raza);
		raza.setAnimal(this);

		return raza;
	}

	public Raza removeRaza(Raza raza) {
		getRazas().remove(raza);
		raza.setAnimal(null);

		return raza;
	}

}