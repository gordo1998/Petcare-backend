package petcare.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import petcare.daoF.AnimalJpa;
import petcare.entities.Animal;
import petcare.serviceF.AnimalIntS;
@RestController
public class AnimalCtr {
	@Autowired
	AnimalJpa animal;
	
	@GetMapping(value = "getAnimales", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> getAnimales(){
		List<String> nameAnimal = new ArrayList<>();
		
		
		for (Animal a: animal.findAll()) {
			nameAnimal.add(a.getNombre());
		}
		
		return nameAnimal;
	}
	
	
	
}
