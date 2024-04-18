package petcare.entities;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the cuidadoranimal database table.
 * 
 */
@Entity
@NamedQuery(name="Cuidadoranimal.findAll", query="SELECT c FROM Cuidadoranimal c")
public class Cuidadoranimal implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CuidadoranimalPK id;

	public Cuidadoranimal() {
	}

	public CuidadoranimalPK getId() {
		return this.id;
	}

	public void setId(CuidadoranimalPK id) {
		this.id = id;
	}

}