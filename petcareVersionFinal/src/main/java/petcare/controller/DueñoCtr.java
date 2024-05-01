package petcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;
import petcare.daoF.DueñoJpa;
import petcare.entities.Dueño;

@RestController
public class DueñoCtr {

	@Autowired
	DueñoJpa jpa;
	
	@PutMapping(value = "addDueñoAccess/{idDueño}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void addAcces(@PathVariable("idDueño") int idDueño) {
		if(jpa.numberTime(idDueño) <= 0) {
			Dueño dueño = jpa.getById(idDueño);
			dueño.setAccesFirstTime(1);
			jpa.save(dueño);
		}
	}
	
	@GetMapping(value = "getTimeAccessDueño/{idDueño}", produces = MediaType.APPLICATION_JSON_VALUE)
	public int accessTime(@PathVariable("idDueño") int idDueño) {
		return jpa.numberTime(idDueño);
	}
}
