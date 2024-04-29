package petcare.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import petcare.entities.Cuenta;
import petcare.entities.Cuidador;
import petcare.serviceF.CuentaIntS;
import petcare.serviceF.CuidadorIntS;

@RestController
public class CuidadorCtr {
	
	@Autowired
	CuidadorIntS jpa;
	
	
	@GetMapping(value = "getCuidadores", produces = MediaType.APPLICATION_JSON_VALUE)
	List<Cuidador> getCuidadores() {
		return jpa.retrieveCuidadores();
	}
	
	@PostMapping(value = "dueñoActivo", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void accessLogin(@RequestBody List<Integer> n) {
		jpa.updateAccess(n.get(0), n.get(1));
	}
	
	@GetMapping(value = "getAccesTimes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	int getAccesTime(@PathVariable("id") int a) {
		return jpa.retrieveAcces(a);
	}
	

	
}
