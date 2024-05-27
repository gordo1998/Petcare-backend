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
import petcare.daoF.ReservaJpa;
import petcare.entities.Cuenta;
import petcare.entities.Cuidador;
import petcare.entities.Dueño;
import petcare.entities.Reserva;
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
	
	@PostMapping(value = "addReserva", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void addReserva(@RequestBody List<Integer> datosReserva) {
		Reserva reserva = new Reserva(jpaC.getById(datosReserva.get(0)), //Este es el Cuidador
									  jpaD.getById(datosReserva.get(1))//Este es el Dueño
									  //datosReserva.get(2),//Este es el mes
									  //datosReserva.get(3),//Este es el día
									  ); //Este es la hora
		jpa.save(reserva);
	}
	
	
	@GetMapping(value = "getReservasDueño/{idDueño}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Map<String, String>> getReservas(@PathVariable("idDueño") int idDueño){
		List<Reserva> reservas = reservaService.retrieveReservasByDueño(idDueño);//Cojo todas las reservas de un dueño
		
		Map<String, Map<String, String>> m = new HashMap<>();
		Map<String, String> mcuidadorDatosReserva = new HashMap<>();
		for (Reserva r: reservas) {//Iteramos en cada reserva
			Cuidador cuidador = r.getCuidador();//Creamos un nuevo cuidador y de la reserva sacamos el cuidador de esa reserva 
			Cuenta cuentaCuidador = cuidador.getCuenta();//Ahora, de ese cuidador vamos 
			
			
			mcuidadorDatosReserva.put("Nombre: ", cuentaCuidador.getNombre());
			mcuidadorDatosReserva.put("Apellido uno: ", cuentaCuidador.getApellidoPrimero());
			mcuidadorDatosReserva.put("Apellido dos: ", cuentaCuidador.getApellidoDos());
			//mcuidadorDatosReserva.put("Mes: ", String.valueOf(r.getMes()));
			//mcuidadorDatosReserva.put("Dia: ", String.valueOf(r.getDia()));
			//mcuidadorDatosReserva.put("Hora: ", String.valueOf(r.getHora()));
			
			
			
			m.put(("Reserva " + r.getIdReserva()), mcuidadorDatosReserva);//Ahora vamos a ingresar la reserva con los datos
		}
		return m;
	}
	
	
	
	@GetMapping(value = "getReservasCuidador/{idCuidador}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Map<String, String>> getReservasCuidador(@PathVariable("idCuidador") int idCuidador){
		List<Reserva> reservas = reservaService.retrieveReservasByCuidador(idCuidador);
		
		Map<String, Map<String, String>> maps = new HashMap<>();
		Map<String, String> datos = new HashMap<>();
		for (Reserva r: reservas) {
			Dueño dueño = r.getDueño();
			Cuenta cuenta = dueño.getCuenta();
			datos.put("Nombre: ", cuenta.getNombre());
			datos.put("Apellido uno: ", cuenta.getApellidoPrimero());
			datos.put("Apellido dos: ", cuenta.getApellidoDos());
			//datos.put("Mes: ", String.valueOf(r.getMes()));
			//datos.put("Dia: ", String.valueOf(r.getDia()));
			//datos.put("Hora: ", String.valueOf(r.getHora()));
			maps.put("Reserva: " + r.getIdReserva(), datos);
		}
		
		return maps;
	}
}
