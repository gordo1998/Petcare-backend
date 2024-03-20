package petcare.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The primary key class for the serviciocuidador database table.
 * 
 */
@Embeddable
public class ServiciocuidadorPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	
	private int idServicio;

	private int idCuidador;

	public ServiciocuidadorPK() {
	}
	public int getIdServicio() {
		return this.idServicio;
	}
	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}
	public int getIdCuidador() {
		return this.idCuidador;
	}
	public void setIdCuidador(int idCuidador) {
		this.idCuidador = idCuidador;
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
			(this.idServicio == castOther.idServicio)
			&& (this.idCuidador == castOther.idCuidador);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idServicio;
		hash = hash * prime + this.idCuidador;
		
		return hash;
	}
}