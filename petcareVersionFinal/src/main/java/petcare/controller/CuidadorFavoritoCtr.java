package petcare.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import petcare.daoF.CuentaJpa;
import petcare.daoF.CuidadorFavoritoJpa;
import petcare.daoF.CuidadorJpa;
import petcare.entities.Cuenta;
import petcare.entities.Cuidador;
import petcare.entities.Cuidadorfavorito;
import petcare.entities.CuidadorfavoritoPK;

@RestController
public class CuidadorFavoritoCtr {
	
	//retrieveCuidadoresFavorito
	
	@Autowired
	CuidadorFavoritoJpa jpa;
	
	@Autowired
	CuidadorJpa cJpa;
	
	@Autowired
	CuentaJpa cuentaJpa;
	
	@GetMapping(value = "getCuidadoresFavoritos/{idDueño}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Map<String, Object>> getCuidadoresFavoritos(@PathVariable("idDueño") int idDueño) {
		Map<String, Map<String, Object>> mapCuidadores = new HashMap<>();
		
		List<Cuidador> cuidadores = new ArrayList<>();
		Map<String, Map<String, Object>> m; 
		List<Cuidadorfavorito> cuidadorFavorito = jpa.retrieveCuidadoresFavorito(idDueño);
		int i = 0;
		for (Cuidadorfavorito f: cuidadorFavorito) {
			Map<String, Object> mapCuidador = new HashMap<>();
			CuidadorfavoritoPK cfPK = f.getId();
			Cuidador cuidador = cJpa.getById(cfPK.getIdCuidadorFavorito());
			Cuenta cuenta = cuentaJpa.getById(cuidador.getIdCuidador());
			cuidadores.add(cuidador);
			mapCuidador.put("idCuidador", cuidador.getIdCuidador());
			mapCuidador.put("nombre", cuenta.getNombre());
			mapCuidador.put("usuario", cuenta.getUsername());
			mapCuidador.put("descripcion corta", cuidador.getDescripcionCorta());
			mapCuidador.put("descripcion", cuidador.getDescripcion());
			mapCuidadores.put("Cuidador " + i, mapCuidador);
			i++;
		}
		return mapCuidadores;
	}
	
	@PostMapping(value = "setCuidadorFavorito", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void setCuidadorFavorito(@RequestBody Map<String, Integer> idsCuidadores) {
		CuidadorfavoritoPK idCuidadorFavorito = new CuidadorfavoritoPK();
		idCuidadorFavorito.setIdCuidadorFavorito(idsCuidadores.get("idCuidador"));
		idCuidadorFavorito.setIdDueñoDelFavorito(idsCuidadores.get("idDueño"));
		Cuidadorfavorito cuidadorFavorito = new Cuidadorfavorito();
		cuidadorFavorito.setId(idCuidadorFavorito);
		jpa.save(cuidadorFavorito);
	}
	
	@DeleteMapping(value = "deleteCuidadorFavorito")
	public void deleteCuidadorFavorito(@RequestBody Map<String, Integer> idCuidadoresFavoritos) {
		CuidadorfavoritoPK idCuidador = new CuidadorfavoritoPK();
		idCuidador.setIdCuidadorFavorito(idCuidadoresFavoritos.get("idCuidador"));
		idCuidador.setIdDueñoDelFavorito(idCuidadoresFavoritos.get("idDueño"));
		Cuidadorfavorito cuidador = jpa.getById(idCuidador);
		jpa.delete(cuidador);
	}
	
}
