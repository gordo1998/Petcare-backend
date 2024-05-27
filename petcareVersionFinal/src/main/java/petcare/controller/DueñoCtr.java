package petcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;
import petcare.daoF.CuentaJpa;
import petcare.daoF.DueñoJpa;
import petcare.entities.Cuenta;
import petcare.entities.Dueño;

@RestController
public class DueñoCtr {

	@Autowired
	DueñoJpa jpa;
	@Autowired
	CuentaJpa cuenta;
	
	@PutMapping(value = "addDueñoAccess/{idDueño}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void addAcces(@PathVariable("idDueño") int idDueño) {
		if(jpa.numberTime(idDueño) <= 0) {
			Dueño dueño = jpa.getById(idDueño);
			dueño.setAccesFirstTime(1);
			jpa.save(dueño);
		}
	}
	
	
	@PostMapping(value = "addDueño")
	public void addDueño(@RequestBody List<String> correo) {
		
		Dueño d = new Dueño();
		Cuenta c = cuenta.getById(cuenta.getIdByEmail(correo.get(0)));
		d.setCuenta(c);
		jpa.save(d);
	}
	
	@PutMapping(value = "updateDueño", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateDueño() {
		
	}
	
	
	
	@Autowired
	CuentaJpa c;
	
	@GetMapping(value = "getLastIdCuenta", produces = MediaType.APPLICATION_JSON_VALUE)
	public int getLastIdCuenta() {
		
		return c.getLastCuenta();
	}
	
	@GetMapping(value = "getTimeAccessDueño/{idDueño}", produces = MediaType.APPLICATION_JSON_VALUE)
	public int accessTime(@PathVariable("idDueño") int idDueño) {
		return jpa.numberTime(idDueño);
	}
}
