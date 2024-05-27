package petcare.entities;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the cuidadorfavorito database table.
 * 
 */
@Entity
@NamedQuery(name="Cuidadorfavorito.findAll", query="SELECT c FROM Cuidadorfavorito c")
public class Cuidadorfavorito implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CuidadorfavoritoPK id;

	public Cuidadorfavorito() {
	}

	public CuidadorfavoritoPK getId() {
		return this.id;
	}

	public void setId(CuidadorfavoritoPK id) {
		this.id = id;
	}

}