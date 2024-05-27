package petcare.entities;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the mascotareservada database table.
 * 
 */
@Entity
@NamedQuery(name="Mascotareservada.findAll", query="SELECT m FROM Mascotareservada m")
public class Mascotareservada implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MascotareservadaPK id;

	public Mascotareservada() {
	}

	public MascotareservadaPK getId() {
		return this.id;
	}

	public void setId(MascotareservadaPK id) {
		this.id = id;
	}

}