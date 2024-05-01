package petcare.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import petcare.daoF.RazaJpa;
import petcare.entities.Raza;

@RestController
public class RazaCtr {
	
	@Autowired
	RazaJpa jpa;
	
	@GetMapping(value = "getRazas/{idAnimal}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> getRazas(@PathVariable("idAnimal") int idAnimal) {
		List<String> nameRazas = new ArrayList<>();
		for(Raza r: jpa.getRazaByAnimal(idAnimal)) {
			nameRazas.add(r.getNombre());
		}
		return nameRazas;
	}
}
