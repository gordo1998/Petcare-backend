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

import petcare.daoF.RazaJpa;
import petcare.entities.Raza;

@RestController
public class RazaCtr {
	
	@Autowired
	RazaJpa jpa;
	
	@GetMapping(value = "getRazas/{idAnimal}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Map<String, Object>> getRazas(@PathVariable("idAnimal") int idAnimal) {
		int i = 1;
		Map<String, Map<String, Object>> mGeneral = new HashMap<>();
		List<Raza> racista = jpa.getRazaByAnimal(idAnimal);
		for(Raza r: racista) {
			Map<String, Object> mPorRaza = new HashMap<>();
			mPorRaza.put("id", r.getIdRaza());
			mPorRaza.put("nombre", r.getNombre());
			mGeneral.put("Raza " + i, mPorRaza);
			i++;
			
		}
		return mGeneral;
	}
}
