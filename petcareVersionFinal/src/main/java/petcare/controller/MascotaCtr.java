package petcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import petcare.daoF.DueñoJpa;
import petcare.daoF.MascotaJpa;
import petcare.daoF.RazaJpa;
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
	public List<Mascota> getMascotasByDueño(@PathVariable("idDueño") int idDueño) {
		return jpa.retrieveMascotas(idDueño);
	}
	
	
	
	
	
}
