package petcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import petcare.entities.Cuenta;
import petcare.service.Implementations.CuentaImpS;
import petcare.service.Interfaces.CuentaIntS;

@RestController
public class CuentasCtr {
	
	@Autowired
	CuentaIntS services;
	//private CuentaImpS services = new CuentaImpS();
	
	@PostMapping(value = "registroCuenta", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	boolean registerCuenta(@RequestBody List<String> datosUser) {
		Cuenta cuenta = new Cuenta();
		cuenta.setEmail(datosUser.get(0));
		cuenta.setPasswd(datosUser.get(1));
		return services.addCuenta(cuenta);
	}
	
	@PostMapping(value = "loginCuenta", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	Cuenta loginCuenta(@RequestBody List<String> datosUser) {
		String email = datosUser.get(0);
		String contrasenya = datosUser.get(1);
		
		return services.retriveCuentas(email, contrasenya);
	}
	
	@PostMapping(value = "loginCorreo", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	Cuenta loginCorreo(@RequestBody List<String> datosUser) {
		String email = datosUser.get(0);
		System.out.print("Linea de prueba: ");
		System.out.print(email);
		return services.retriveCuentas(email);
	}
	
	@DeleteMapping(value = "deleteCuenta", produces = MediaType.APPLICATION_JSON_VALUE)
	void deleteCuenta(@RequestBody Cuenta cuenta) {
		services.removeCuenta(cuenta);
	}
	
	@DeleteMapping(value = "deleteCuentaId/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	void deleteCuenta(@RequestBody int id) {
		services.removeCuenta(id);
	}
	
	@PutMapping(value = "updateCuenta", consumes = MediaType.APPLICATION_JSON_VALUE)
	void updateCuenta(@RequestBody Cuenta cuenta) {
		services.addCuenta(cuenta);
	}
}
