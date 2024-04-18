package petcare.entities;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * The primary key class for the serviciocuidador database table.
 * 
 */
@Embeddable
public class ServiciocuidadorPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int idServicioS;

	@Column(insertable=false, updatable=false)
	private int idCuidadorS;

	public ServiciocuidadorPK() {
	}
	public int getIdServicioS() {
		return this.idServicioS;
	}
	public void setIdServicioS(int idServicioS) {
		this.idServicioS = idServicioS;
	}
	public int getIdCuidadorS() {
		return this.idCuidadorS;
	}
	public void setIdCuidadorS(int idCuidadorS) {
		this.idCuidadorS = idCuidadorS;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ServiciocuidadorPK)) {
			return false;
		}
		ServiciocuidadorPK castOther = (ServiciocuidadorPK)other;
		return 
			(this.idServicioS == castOther.idServicioS)
			&& (this.idCuidadorS == castOther.idCuidadorS);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idServicioS;
		hash = hash * prime + this.idCuidadorS;
		
		return hash;
	}
}