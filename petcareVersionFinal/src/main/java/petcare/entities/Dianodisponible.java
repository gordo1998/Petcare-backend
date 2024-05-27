package petcare.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Time;


/**
 * The persistent class for the dianodisponible database table.
 * 
 */
@Entity
@NamedQuery(name="Dianodisponible.findAll", query="SELECT d FROM Dianodisponible d")
public class Dianodisponible implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDiasNoDisponible;
	
	@ManyToOne
	@JoinColumn(name="cuidadorDiaNoDisponible")
	private Cuidador cuidadorDiaNoDisponible;

	private int dia;

	private Time hora;

	private int mes;

	public Dianodisponible() {
	}

	public int getIdDiasNoDisponible() {
		return this.idDiasNoDisponible;
	}

	public void setIdDiasNoDisponible(int idDiasNoDisponible) {
		this.idDiasNoDisponible = idDiasNoDisponible;
	}

	public Cuidador getCuidadorDiaNoDisponible() {
		return this.cuidadorDiaNoDisponible;
	}

	public void setCuidadorDiaNoDisponible(Cuidador cuidadorDiaNoDisponible) {
		this.cuidadorDiaNoDisponible = cuidadorDiaNoDisponible;
	}

	public int getDia() {
		return this.dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public Time getHora() {
		return this.hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public int getMes() {
		return this.mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

}