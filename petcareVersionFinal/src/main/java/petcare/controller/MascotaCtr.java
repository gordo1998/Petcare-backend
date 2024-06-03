package petcare.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import petcare.daoF.DueñoJpa;
import petcare.daoF.MascotaJpa;
import petcare.daoF.RazaJpa;
import petcare.entities.Animal;
import petcare.entities.Dueño;
import petcare.entities.Mascota;
import petcare.entities.Raza;

@RestController
public class MascotaCtr {
	@Autowired
	MascotaJpa jpa;
	@Autowired 
	RazaJpa razaJpa;
	@Autowired
	DueñoJpa dueñoJpa;
	
	@PostMapping(value = "addMascota", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addMascot(@RequestBody List<String> mascota) {
		Mascota m = new Mascota();
		m.setNombre(mascota.get(0));
		m.setEdad(Integer.parseInt(mascota.get(1)));
		m.setPeso(Float.parseFloat(mascota.get(2)));
		m.setDescEnfermedades(mascota.get(3));
		m.setDescSobreMascota(mascota.get(4));
		Raza r = razaJpa.getById(Integer.parseInt(mascota.get(5)));
		Dueño d =  dueñoJpa.getById(Integer.parseInt(mascota.get(6)));
		m.setRaza(r);
		m.setDueño(d);
		
		jpa.save(m);
	}
	
	@GetMapping(value = "getMascotasDueño/{idDueño}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Map<String, Object>> getMascotasByDueño(@PathVariable("idDueño") int idDueño) {
		Map<String, Map<String, Object>> mascotas = new HashMap<>(); 
		int idMascota = 0;
		for(Mascota m: jpa.retrieveMascotas(idDueño)) {
			List<String> strDatosMascota = new ArrayList<>();
			Raza r = m.getRaza();
			Animal a = r.getAnimal();
			
			Map<String, Object> mpDatosMascota = new HashMap<>();
			mpDatosMascota.put("idMascota", m.getIdMascota());
			mpDatosMascota.put("nombre", m.getNombre());
			mpDatosMascota.put("raza", r.getNombre());
			mpDatosMascota.put("animal", a.getNombre());
			mpDatosMascota.put("edad", m.getEdad());
			mpDatosMascota.put("peso", m.getPeso());
			mpDatosMascota.put("enfermedades", m.getDescEnfermedades());
			mpDatosMascota.put("Descripcion", m.getDescSobreMascota());
			mascotas.put("Mascota " + idMascota, mpDatosMascota);
			idMascota++;
		}
		return mascotas;
	}
	
	@GetMapping(value = "getMascota/{idMascota}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> getMascota(@PathVariable("idMascota") int idMascota){
		Mascota mascota = jpa.getById(idMascota);
		Raza raza = mascota.getRaza();
		Animal animal = raza.getAnimal();
		Map<String, Object> mapMascota = new HashMap<>();
		mapMascota.put("idMascota", mascota.getIdMascota());
		mapMascota.put("nombre", mascota.getNombre());
		mapMascota.put("raza", raza.getNombre());
		mapMascota.put("animal", animal.getNombre());
		mapMascota.put("descripcion", mascota.getDescSobreMascota());
		mapMascota.put("descripcion enfermedades", mascota.getDescEnfermedades());
		return mapMascota;
	}
	
	@DeleteMapping(value = "deleteMascota/{idMascota}")
	public void eliminarMascota(@PathVariable("idMascota") int idMascota) {
		Mascota mascota = jpa.getById(idMascota);
		jpa.delete(mascota);
	}
	
	
	
	
	
}
