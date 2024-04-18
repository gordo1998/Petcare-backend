package petcare.entities;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * The primary key class for the mascotareservada database table.
 * 
 */
@Embeddable
public class MascotareservadaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int idReservaR;

	@Column(insertable=false, updatable=false)
	private int idMascotaR;

	public MascotareservadaPK() {
	}
	public int getIdReservaR() {
		return this.idReservaR;
	}
	public void setIdReservaR(int idReservaR) {
		this.idReservaR = idReservaR;
	}
	public int getIdMascotaR() {
		return this.idMascotaR;
	}
	public void setIdMascotaR(int idMascotaR) {
		this.idMascotaR = idMascotaR;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MascotareservadaPK)) {
			return false;
		}
		MascotareservadaPK castOther = (MascotareservadaPK)other;
		return 
			(this.idReservaR == castOther.idReservaR)
			&& (this.idMascotaR == castOther.idMascotaR);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idReservaR;
		hash = hash * prime + this.idMascotaR;
		
		return hash;
	}
}