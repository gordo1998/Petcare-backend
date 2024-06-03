package petcare.controller;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import petcare.daoF.CuidadorJpa;
import petcare.daoF.DueñoJpa;
import petcare.daoF.MascotaJpa;
import petcare.daoF.MascotaReservadaJpa;
import petcare.daoF.RazaJpa;
import petcare.daoF.ReservaJpa;
import petcare.daoF.ServicioJpa;
import petcare.entities.Animal;
import petcare.entities.Cuenta;
import petcare.entities.Cuidador;
import petcare.entities.Dueño;
import petcare.entities.Mascota;
import petcare.entities.MascotareservadaPK;
import petcare.entities.Raza;
import petcare.entities.Reserva;
import petcare.entities.Servicio;
import petcare.serviceF.ReservaIntS;

@RestController
public class ReservaCtr {
	@Autowired
	ReservaIntS reservaService;
	
	@Autowired
	ReservaJpa jpa;
	
	@Autowired
	CuidadorJpa jpaC;
	
	@Autowired
	DueñoJpa jpaD;
	
	@Autowired
	MascotaReservadaJpa mJpa;
	
	@Autowired
	MascotaJpa mascota;
	
	@Autowired
	RazaJpa raza;
	
	@Autowired
	ServicioJpa sJpa;
	
	@PostMapping(value = "addReserva", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public int addReserva(@RequestBody Map<String, Integer> datosReserva) {
		Reserva reserva = new Reserva();
									  
		//Map.Entry<String, String> entrada: mCuenta.entrySet()
		for(Map.Entry<String, Integer> r: datosReserva.entrySet()){
			switch (r.getKey()) {
			case "idCuidador":
				Cuidador c = jpaC.getById(r.getValue());
				reserva.setCuidador(c);
				break;
			case "idDueño":
				Dueño d = jpaD.getById(r.getValue());
				reserva.setDuenyo(d);			
				break;
			case "idServicio":
				Servicio s = sJpa.getById(r.getValue());
				reserva.setServ(s);
				break;
			}
		}
		
		
		Reserva r = jpa.save(reserva);
		return r.getIdReserva();
	}
	
	
	@GetMapping(value = "getReservasDueño/{idDueño}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Map<String, Object>> getReservas(@PathVariable("idDueño") int idDueño){
		List<Reserva> reservas = reservaService.retrieveReservasByDueño(idDueño);//Cojo todas las reservas de un dueño
		
		Map<String, Map<String, Object>> reservasMap = new HashMap<>();
		
		for (Reserva r: reservas) {//Iteramos en cada reserva
			Map<String, Object> reserva = new HashMap<>();
			Cuidador cuidador = r.getCuidador();//Creamos un nuevo cuidador y de la reserva sacamos el cuidador de esa reserva 
			Cuenta cuentaCuidador = cuidador.getCuenta();//Ahora, de ese cuidador vamos 
			Servicio servicio = r.getServ();
			Map<String, Map<String, Object>> lMascotas = r.getMascotas();
			reserva.put("Nombre: ", cuentaCuidador.getNombre());
			reserva.put("Apellido uno", cuentaCuidador.getApellidoPrimero());
			reserva.put("Apellido dos", cuentaCuidador.getApellidoDos());
			reserva.put("mascota", lMascotas);
			reserva.put("Servicio", servicio.getNombreServicio());
			reservasMap.put(("Reserva" + r.getIdReserva()), reserva);//Ahora vamos a ingresar la reserva con los datos
		}
		return reservasMap;
	}
	
	
	
	@GetMapping(value = "getReservasCuidador/{idCuidador}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Map<String, Object>> getReservasCuidador(@PathVariable("idCuidador") int idCuidador){
		List<Reserva> reservas = reservaService.retrieveReservasByCuidador(idCuidador);
		
		Map<String, Map<String, Object>> mapReservas = new HashMap<>();
		
		for (Reserva r: reservas) {
			
			Map<String, Object> mapReserva = new HashMap<>();
			Dueño dueño = r.getDuenyo();
			Cuenta cuenta = dueño.getCuenta();
			Servicio servicio = r.getServ();
			Map<String, Map<String, Object>> lMascotas = r.getMascotas();//Devuelve un mapa de todas las mascotas
			mapReserva.put("Nombre: ", cuenta.getNombre());
			mapReserva.put("Apellido uno: ", cuenta.getApellidoPrimero());
			mapReserva.put("Apellido dos: ", cuenta.getApellidoDos());
			mapReserva.put("Mascotas", lMascotas);
			mapReserva.put("Servicio", servicio.getNombreServicio());
			
			mapReservas.put("Reserva: " + r.getIdReserva(), mapReserva);
			
		}
		
		return mapReservas;
	}
	
	
}
