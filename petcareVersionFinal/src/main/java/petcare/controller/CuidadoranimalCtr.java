package petcare.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import petcare.daoF.CuidadoranimalJpa;
import petcare.entities.Animal;
import petcare.entities.Cuidadoranimal;
import petcare.entities.CuidadoranimalPK;

@RestController
public class CuidadoranimalCtr {
	
	@Autowired
	CuidadoranimalJpa jpa;
	
	@GetMapping(value = "getCuidadorAnimal/{idCuidador}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Animal> getCuidadoresAnimal(@PathVariable("idCuidador") int idCuidador) {
		
		List<Cuidadoranimal> cuidadorAnimal = jpa.retrievesAnimalesCuidador(idCuidador);
		
		List<Animal> anim = new ArrayList<>();
		
		for (Cuidadoranimal a: cuidadorAnimal){
			
			
			
			CuidadoranimalPK idCuidadorAnimal = a.getId();
			
			
		}
		
		return null;
	}
	
	@GetMapping(value = "getAnimalCuidador/id")
	public void getAnimalCuidador() {
		
	}
}
