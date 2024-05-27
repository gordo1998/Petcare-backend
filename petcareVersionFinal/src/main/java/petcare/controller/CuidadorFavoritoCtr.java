package petcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;


import petcare.daoF.CuidadorFavoritoJpa;
import petcare.entities.Cuidadorfavorito;

@RestController
public class CuidadorFavoritoCtr {
	
	//retrieveCuidadoresFavorito
	
	@Autowired
	CuidadorFavoritoJpa jpa;
	
	@GetMapping(value = "getCuidadoresFavoritos/{idDueño}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Cuidadorfavorito> getCuidadoresFavoritos(@PathVariable("idDueño") int idDueño) {
		return jpa.retrieveCuidadoresFavorito(idDueño);
	}
}
