package petcare.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import petcare.daoF.MascotaJpa;
import petcare.daoF.MascotaReservadaJpa;
import petcare.daoF.RazaJpa;
import petcare.entities.Animal;
import petcare.entities.Mascota;
import petcare.entities.Mascotareservada;
import petcare.entities.MascotareservadaPK;
import petcare.entities.Raza;

@RestController
public class MascotaReservadaCtr {

	@Autowired
	MascotaReservadaJpa jpa;
	
	@Autowired
	MascotaJpa mJpa;
	
	@Autowired
	RazaJpa rJpa;
	
	/*
	@GetMapping(value = "getMascotasReservadas/{idDueño}")
	public Map<String, String> getMascotasReservada(@PathVariable("idDueño") int idDueño) {
		List<MascotareservadaPK> mascDuenyo = jpa.getMascotasReservadasByDueño(idDueño);
		Map<String, String> map = new HashMap<>();
		for (Integer i: mascDuenyo) {
			Mascota m = mJpa.getById(i);
			Raza r = m.getRaza();
			Animal a = r.getAnimal();
			map.put("nombre", m.getNombre());
			map.put("animal", a.getNombre());
		}
		return map;
	}
	*/
	
	@PostMapping(value = "setMascotaReservada")
	public void setMascotaReservada(@RequestBody Map<String, Object> idsReservaMascotas) {
		List<Integer> idsMascotas = (List<Integer>) idsReservaMascotas.get("listaMascotas");
		MascotareservadaPK m = new MascotareservadaPK();
		
		for(Integer list: idsMascotas) {
			m.setIdMascotaR(list);
			m.setIdReservaR((Integer) idsReservaMascotas.get("idReserva"));
			Mascotareservada mr = new Mascotareservada();
			mr.setId(m);
			jpa.save(mr);
		}
		
	}
}
