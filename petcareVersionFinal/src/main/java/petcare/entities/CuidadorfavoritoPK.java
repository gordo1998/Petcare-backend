package petcare.entities;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * The primary key class for the cuidadorfavorito database table.
 * 
 */
@Embeddable
public class CuidadorfavoritoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int idCuidadorFavorito;

	@Column(insertable=false, updatable=false)
	private int idDueñoDelFavorito;

	public CuidadorfavoritoPK() {
	}
	public int getIdCuidadorFavorito() {
		return this.idCuidadorFavorito;
	}
	public void setIdCuidadorFavorito(int idCuidadorFavorito) {
		this.idCuidadorFavorito = idCuidadorFavorito;
	}
	public int getIdDueñoDelFavorito() {
		return this.idDueñoDelFavorito;
	}
	public void setIdDueñoDelFavorito(int idDueñoDelFavorito) {
		this.idDueñoDelFavorito = idDueñoDelFavorito;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CuidadorfavoritoPK)) {
			return false;
		}
		CuidadorfavoritoPK castOther = (CuidadorfavoritoPK)other;
		return 
			(this.idCuidadorFavorito == castOther.idCuidadorFavorito)
			&& (this.idDueñoDelFavorito == castOther.idDueñoDelFavorito);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idCuidadorFavorito;
		hash = hash * prime + this.idDueñoDelFavorito;
		
		return hash;
	}
}