package petcare.entities;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * The primary key class for the cuidadoranimal database table.
 * 
 */
@Embeddable
public class CuidadoranimalPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int idAnimalC;

	@Column(insertable=false, updatable=false)
	private int idCuidadorC;

	public CuidadoranimalPK() {
	}
	public int getIdAnimalC() {
		return this.idAnimalC;
	}
	public void setIdAnimalC(int idAnimalC) {
		this.idAnimalC = idAnimalC;
	}
	public int getIdCuidadorC() {
		return this.idCuidadorC;
	}
	public void setIdCuidadorC(int idCuidadorC) {
		this.idCuidadorC = idCuidadorC;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CuidadoranimalPK)) {
			return false;
		}
		CuidadoranimalPK castOther = (CuidadoranimalPK)other;
		return 
			(this.idAnimalC == castOther.idAnimalC)
			&& (this.idCuidadorC == castOther.idCuidadorC);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idAnimalC;
		hash = hash * prime + this.idCuidadorC;
		
		return hash;
	}
}