package petcare.controller;

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

import petcare.entities.Cuenta;
import petcare.entities.Cuidador;
import petcare.entities.Dueño;
import petcare.entities.Reserva;
import petcare.serviceF.ReservaIntS;

@RestController
public class ReservaCtr {
	@Autowired
	ReservaIntS reservaService;
	
	@PostMapping(value = "addReserva", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void addReserva(@RequestBody List<Integer> datosReserva) {
		int cuidador = datosReserva.get(0);
		int dueño = datosReserva.get(1);
		reservaService.addReserva(cuidador, dueño);
	}
	
	@GetMapping(value = "getReservas/{idDueño}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, List<String>> getReservas(@PathVariable("idDueño") int idDueño){
		List<Reserva> reservas = reservaService.retrieveReservasByDueño(idDueño);
		
		Dueño dueño = new Dueño();
		
		
		Map<String, List<String>> m = new HashMap<>();
		
		for (Reserva r: reservas) {
			Cuidador cuidador = r.getCuidador();
			Cuenta cuentaCuidador = cuidador.getCuenta();
			List<String> cuidadorDatosReserva = new ArrayList<>();
			cuidadorDatosReserva.add(cuentaCuidador.getNombre());
			cuidadorDatosReserva.add(cuentaCuidador.getApellidoPrimero());
			cuidadorDatosReserva.add(cuentaCuidador.getApellidoDos());
			
			m.put(("Reserva " + r.getIdReserva()), cuidadorDatosReserva);
		}
		return m;
	}
}
