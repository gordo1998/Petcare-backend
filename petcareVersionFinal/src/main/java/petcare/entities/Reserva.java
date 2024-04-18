package petcare.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Time;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * The persistent class for the reservas database table.
 * 
 */
@Entity
@Table(name="reservas")
@NamedQuery(name="Reserva.findAll", query="SELECT r FROM Reserva r")
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idReserva;

	private int dia;

	private Time hora;

	private int mes;

	private String ubicacionServicio;

	//bi-directional many-to-one association to Cuidador
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="cuidadorR")
	private Cuidador cuidador;

	//bi-directional many-to-one association to Dueño
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="duenyoR")
	private Dueño dueño;

	//bi-directional many-to-many association to Mascota
	@ManyToMany
	@JoinTable(
		name="mascotareservada"
		, joinColumns={
			@JoinColumn(name="idReservaR")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idMascotaR")
			}
		)
	private List<Mascota> mascotas;

	public Reserva() {
	}

	public int getIdReserva() {
		return this.idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
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

	public String getUbicacionServicio() {
		return this.ubicacionServicio;
	}

	public void setUbicacionServicio(String ubicacionServicio) {
		this.ubicacionServicio = ubicacionServicio;
	}

	public Cuidador getCuidador() {
		return this.cuidador;
	}

	public void setCuidador(Cuidador cuidador) {
		this.cuidador = cuidador;
	}

	public Dueño getDueño() {
		return this.dueño;
	}

	public void setDueño(Dueño dueño) {
		this.dueño = dueño;
	}

	public List<Mascota> getMascotas() {
		return this.mascotas;
	}

	public void setMascotas(List<Mascota> mascotas) {
		this.mascotas = mascotas;
	}

}