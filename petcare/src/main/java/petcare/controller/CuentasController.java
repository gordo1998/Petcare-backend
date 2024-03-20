package petcare.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import petcare.dao.ServicioCuidadoresJPA;
import petcare.entities.Cuenta;
import petcare.entities.Cuidador;
import petcare.entities.Reserva;
import petcare.entities.Sacarcuidadore;
import petcare.entities.Servicio;
import petcare.entities.Serviciocuidador;
import petcare.service.CuentaServices;
import petcare.service.GetCuidadoresService;
import petcare.service.ReservaService;
import petcare.service.ServiceService;

@RestController
public class CuentasController {
	
	@Autowired
	CuentaServices services;
	@Autowired
	GetCuidadoresService serviceCuidador;
	@Autowired
	ServiceService serviceServicio;
	@Autowired
	ReservaService reservaService;
	
	
	
	@PostMapping(value = "registroCuenta", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	boolean registerCuenta(@RequestBody Cuenta cuenta) {
		return services.addCuenta(cuenta);
	}
	
	@PostMapping(value = "loginCuenta", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	Cuenta loginCuenta(@RequestBody Cuenta cuenta) {
		return services.retrieveCuenta(cuenta.getEmail(), cuenta.getPasswd());
	}
		
	@DeleteMapping(value = "deleteCuenta", produces = MediaType.APPLICATION_JSON_VALUE)
	boolean deleteCuenta(@RequestBody Cuenta cuenta) {
		return services.deleteCuenta(cuenta);
	}
	
	@DeleteMapping(value = "deleteCuentaId/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	boolean deleteCuenta(@RequestBody int id) {
		return services.deleteCuenta(id);
	}
	
	@PutMapping(value = "updateCuenta", consumes = MediaType.APPLICATION_JSON_VALUE)
	boolean updateCuenta(@RequestBody Cuenta cuenta) {
		return services.updateCuenta(cuenta);
	}
	
	@GetMapping(value = "getCuidadores", produces = MediaType.APPLICATION_JSON_VALUE)
	List<Sacarcuidadore> getCuidadores() {
		return serviceCuidador.getCuidadores();
	}
	
	@GetMapping(value = "getServicios", produces = MediaType.APPLICATION_JSON_VALUE)
	List<String> getServicios(){
		List<Servicio> servicios = serviceServicio.getServicios();
		List<String> strServicios = new ArrayList<>();
		
		for (Servicio s: servicios) {
			strServicios.add(s.getNombreServicio());		
		}
		
		return strServicios;
	}
	
	
	
	@Autowired
	ServicioCuidadoresJPA jpa;
	
	@GetMapping(value = "getServiciosCuidador/{idServicio}", produces = MediaType.APPLICATION_JSON_VALUE)
	Map<String, List<String>> getlistServCuidadores(@PathVariable("idServicio") int idServicio){
		
		List<Serviciocuidador> cuidadores = jpa.getServicioCuidador(idServicio);
		List<Cuidador> listaCuidadores = new ArrayList<>();
		for (Serviciocuidador c: cuidadores) {
			listaCuidadores.add(c.getCuidador());
		}
		
		List<Cuenta> listaCuentas = new ArrayList<>();
		
		for (Cuidador y: listaCuidadores) {
			listaCuentas.add(y.getCuenta());
		}
		
		Map<String, List<String>> mapString = new HashMap<>();
		
		
		for (Cuenta z: listaCuentas) {
			//listaString.add()
			List<String> lista = new ArrayList<>();
			lista.add(z.getNombre());
			lista.add(z.getApellidoPrimero());
			lista.add(z.getApellidoDos());
			lista.add(String.valueOf(z.getIdCuenta()));
			mapString.put((z.getNombre() + " " + z.getApellidoPrimero() + " " + z.getApellidoDos()), lista);
		}
		
		return mapString;
	}
	
	@PostMapping(value = "addReserva", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void addReserva(@RequestBody Reserva reserva) {
		reservaService.addReserva(reserva);
	}
	
	
	
	
	
	
}
