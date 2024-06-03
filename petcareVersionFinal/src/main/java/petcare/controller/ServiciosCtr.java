package petcare.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import petcare.daoF.CuidadorJpa;
import petcare.daoF.ServicioJpa;
import petcare.entities.Cuidador;
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

	
	
	@Autowired
	ServicioJpa jpa;
	
	@Autowired
	CuidadorJpa cJpa;
	
	@GetMapping(value = "getServicios/{idCuidador}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Map<String, Object>> getServicios(@PathVariable("idCuidador") int idCuidador){
		
		Cuidador cuidador = cJpa.getById(idCuidador);
		
		Map<String, Map<String, Object>> servicios = cuidador.getServicios();
		
		
		return servicios;
	}
	
	
	
	
}
