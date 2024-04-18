package petcare.entities;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the serviciocuidador database table.
 * 
 */
@Entity
@NamedQuery(name="Serviciocuidador.findAll", query="SELECT s FROM Serviciocuidador s")
public class Serviciocuidador implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ServiciocuidadorPK id;

	public Serviciocuidador() {
	}

	public ServiciocuidadorPK getId() {
		return this.id;
	}

	public void setId(ServiciocuidadorPK id) {
		this.id = id;
	}

}