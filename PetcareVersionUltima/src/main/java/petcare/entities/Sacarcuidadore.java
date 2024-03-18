package petcare.entities;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the sacarcuidadores database table.
 * 
 */
@Entity
@Table(name="sacarcuidadores")
@NamedQuery(name="Sacarcuidadore.findAll", query="SELECT s FROM Sacarcuidadore s")
public class Sacarcuidadore implements Serializable {
	private static final long serialVersionUID = 1L;

	private String apellidoDos;

	private String apellidoPrimero;

	private int cuentaCuidador;

	@Lob
	private String descripcion;

	private String email;
	@Id
	private int idCuenta;
	
	private int idCuidador;

	private int movil;

	private String nombre;

	private String passwd;

	private int telefono;

	private byte tipoPerdil;

	private String urlImagenes;

	private String username;

	public Sacarcuidadore() {
	}

	public String getApellidoDos() {
		return this.apellidoDos;
	}

	public void setApellidoDos(String apellidoDos) {
		this.apellidoDos = apellidoDos;
	}

	public String getApellidoPrimero() {
		return this.apellidoPrimero;
	}

	public void setApellidoPrimero(String apellidoPrimero) {
		this.apellidoPrimero = apellidoPrimero;
	}

	public int getCuentaCuidador() {
		return this.cuentaCuidador;
	}

	public void setCuentaCuidador(int cuentaCuidador) {
		this.cuentaCuidador = cuentaCuidador;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdCuenta() {
		return this.idCuenta;
	}

	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}

	public int getIdCuidador() {
		return this.idCuidador;
	}

	public void setIdCuidador(int idCuidador) {
		this.idCuidador = idCuidador;
	}

	public int getMovil() {
		return this.movil;
	}

	public void setMovil(int movil) {
		this.movil = movil;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPasswd() {
		return this.passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public int getTelefono() {
		return this.telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public byte getTipoPerdil() {
		return this.tipoPerdil;
	}

	public void setTipoPerdil(byte tipoPerdil) {
		this.tipoPerdil = tipoPerdil;
	}

	public String getUrlImagenes() {
		return this.urlImagenes;
	}

	public void setUrlImagenes(String urlImagenes) {
		this.urlImagenes = urlImagenes;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}