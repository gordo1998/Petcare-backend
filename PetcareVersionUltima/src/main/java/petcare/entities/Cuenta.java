package petcare.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the cuenta database table.
 * 
 */
@Entity
@NamedQuery(name="Cuenta.findAll", query="SELECT c FROM Cuenta c")
public class Cuenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCuenta;

	private String apellidoDos;

	private String apellidoPrimero;

	private String email;

	private int movil;

	private String nombre;

	private String passwd;

	private int telefono;

	private byte tipoPerdil;

	private String urlImagenes;

	private String username;

	//bi-directional many-to-one association to Cuidador
	@OneToMany(mappedBy="cuenta")
	private List<Cuidador> cuidadors;

	//bi-directional many-to-one association to Dueño
	@OneToMany(mappedBy="cuenta")
	private List<Dueño> dueños;

	public Cuenta() {
	}

	public int getIdCuenta() {
		return this.idCuenta;
	}

	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public List<Cuidador> getCuidadors() {
		return this.cuidadors;
	}

	public void setCuidadors(List<Cuidador> cuidadors) {
		this.cuidadors = cuidadors;
	}

	public Cuidador addCuidador(Cuidador cuidador) {
		getCuidadors().add(cuidador);
		cuidador.setCuenta(this);

		return cuidador;
	}

	public Cuidador removeCuidador(Cuidador cuidador) {
		getCuidadors().remove(cuidador);
		cuidador.setCuenta(null);

		return cuidador;
	}

	public List<Dueño> getDueños() {
		return this.dueños;
	}

	public void setDueños(List<Dueño> dueños) {
		this.dueños = dueños;
	}

	public Dueño addDueño(Dueño dueño) {
		getDueños().add(dueño);
		dueño.setCuenta(this);

		return dueño;
	}

	public Dueño removeDueño(Dueño dueño) {
		getDueños().remove(dueño);
		dueño.setCuenta(null);

		return dueño;
	}

}