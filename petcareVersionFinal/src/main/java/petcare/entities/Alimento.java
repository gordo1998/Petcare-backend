package petcare.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the alimento database table.
 * 
 */
@Entity
@NamedQuery(name="Alimento.findAll", query="SELECT a FROM Alimento a")
public class Alimento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAlimento;

	private String nombre;

	//bi-directional many-to-one association to Mascota
	@OneToMany(mappedBy="alimento")
	private List<Mascota> mascotas;

	public Alimento() {
	}

	public int getIdAlimento() {
		return this.idAlimento;
	}

	public void setIdAlimento(int idAlimento) {
		this.idAlimento = idAlimento;
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
		mascota.setAlimento(this);

		return mascota;
	}

	public Mascota removeMascota(Mascota mascota) {
		getMascotas().remove(mascota);
		mascota.setAlimento(null);

		return mascota;
	}

}