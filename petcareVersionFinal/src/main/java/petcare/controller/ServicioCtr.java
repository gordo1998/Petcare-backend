package petcare.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import petcare.entities.Servicio;
import petcare.service.Implementations.ServicioImpS;
import petcare.service.Interfaces.ServicioIntS;

@RestController
public class ServicioCtr {

	ServicioImpS serviceServicio = new ServicioImpS();
	
	@GetMapping(value = "getServicios", produces = MediaType.APPLICATION_JSON_VALUE)
	List<String> getServicios(){
		List<Servicio> servicios = serviceServicio.retrieveServicios();
		List<String> strServicios = new ArrayList<>();
		
		for (Servicio s: servicios) {
			strServicios.add(s.getNombreServicio());		
		}
		
		return strServicios;
	}
	
}
