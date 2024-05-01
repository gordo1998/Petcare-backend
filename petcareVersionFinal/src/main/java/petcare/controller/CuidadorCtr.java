package petcare.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import petcare.daoF.CuidadorJpa;
import petcare.entities.Cuenta;
import petcare.entities.Cuidador;
import petcare.serviceF.CuentaIntS;
import petcare.serviceF.CuidadorIntS;

@RestController
public class CuidadorCtr {
	
	@Autowired
	CuidadorJpa jpa;
	
	
	
	
	@GetMapping(value = "getCuidadores", produces = MediaType.APPLICATION_JSON_VALUE)
	List<Cuidador> getCuidadores() {
		return jpa.findAll();
	}
	
	@PutMapping(value = "dueñoActivo/{idCuidador}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void accessLogin(@PathVariable("idCuidador") int idCuidador) {
		
		
	
		if(jpa.retrieveAccess(idCuidador) <= 0) {
			//jpa.updateAccessFirst(1, idCuidador);
			Cuidador c = jpa.getById(idCuidador);
			c.setAccesFirstTime(1);
		}
		Cuidador c = jpa.getById(idCuidador);
		c.setAccesFirstTime(1);
		jpa.save(c);
		
		
		
	}
	
	@GetMapping(value = "getAccesTimes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	int getAccesTime(@PathVariable("id") int a) {
		return jpa.retrieveAccess(a);
	}
	

	
}
