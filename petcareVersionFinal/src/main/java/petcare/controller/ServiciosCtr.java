package petcare.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import petcare.daoF.ServicioJpa;
import petcare.entities.Servicio;
import petcare.serviceF.ServicioIntS;

@RestController
public class ServiciosCtr {
	@Autowired
	ServicioIntS s; 
	
	@GetMapping(value = "getServicios", produces = MediaType.APPLICATION_JSON_VALUE)
	Map<String, String> getServicios(){
		List<Servicio> servicios = s.retrieveServicios();
		Map<String, String> mpServicios = new HashMap<>();
				
		for (Servicio s: servicios) {
			mpServicios.put(String.valueOf(s.getIdServicio()), s.getNombreServicio());		
		}
		
		return mpServicios;
	}
	
	/*
	@Autowired
	ServicioJpa jpa;
	
	@GetMapping(value = "getServicios", produces = MediaType.APPLICATION_JSON_VALUE)
	List<String> getServicios(){
		List<Servicio> servicios = jpa.findAll();
		List<String> strServicios = new ArrayList<>();
		
		for (Servicio s: servicios) {
			strServicios.add(s.getNombreServicio());		
		}
		
		return strServicios;
	}
	
	*/
	
	
}
