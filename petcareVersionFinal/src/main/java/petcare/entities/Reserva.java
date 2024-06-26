package petcare.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Time;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="cuidadorR")
	private Cuidador cuidador;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="serv")
	private Servicio serv;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="duenyoR")
	private Dueño duenyo;
	
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
	

	private int dia;
	
	

	private Time hora;

	private int mes;
	
	

	private String ubicacionServicio;

	public Reserva() {
	}

	public int getIdReserva() {
		return this.idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public Cuidador getCuidador() {
		return this.cuidador;
	}

	public void setCuidador(Cuidador cuidadorR) {
		this.cuidador = cuidadorR;
	}

	public int getDia() {
		return this.dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public Dueño getDuenyo() {
		return this.duenyo;
	}

	public void setDuenyo(Dueño duenyoR) {
		this.duenyo = duenyoR;
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

	public Servicio getServ() {
		return this.serv;
	}

	public void setServ(Servicio serv) {
		this.serv = serv;
	}

	public String getUbicacionServicio() {
		return this.ubicacionServicio;
	}

	public void setUbicacionServicio(String ubicacionServicio) {
		this.ubicacionServicio = ubicacionServicio;
	}
	
	public Map<String, Map<String, Object>> getMascotas(){
		Map<String, Map<String, Object>> mapMascotas = new HashMap<>();
		int mascota = 0;
		for (Mascota m: this.mascotas) {
			Map<String, Object> mapMascota = new HashMap<>();
			Raza raza = m.getRaza();
			Animal animal = raza.getAnimal();
			mapMascota.put("idMascota", m.getIdMascota());
			mapMascota.put("nombre", m.getNombre());
			mapMascota.put("raza", raza.getNombre());
			mapMascota.put("animal", animal.getNombre());
			mapMascotas.put("mascota" + mascota, mapMascota);
			mascota++;
		}
		return mapMascotas;
	}

}