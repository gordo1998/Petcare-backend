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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import petcare.daoF.CuentaJpa;
import petcare.daoF.DueñoJpa;
import petcare.entities.Cuenta;
import petcare.entities.Dueño;
import petcare.entities.Servicio;
import petcare.serviceF.CuentaImpS;
import petcare.serviceF.CuentaIntS;
import petcare.serviceF.ServicioIntS;

@RestController
public class CuentasCtr {
	
	@Autowired
	CuentaIntS services;
	@Autowired
	DueñoJpa dueño;
	
	@Autowired
	CuentaJpa c;
	//private CuentaImpS services = new CuentaImpS();
	
	@PostMapping(value = "registroCuenta", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	boolean registerCuenta(@RequestBody List<String> datosUser) {
		Cuenta cuenta = new Cuenta();
		cuenta.setNombre(datosUser.get(0));
		cuenta.setApellidoPrimero(datosUser.get(1));
		cuenta.setApellidoDos(datosUser.get(2));
		cuenta.setUsername(datosUser.get(3));
		cuenta.setEmail(datosUser.get(4));
		cuenta.setPasswd(datosUser.get(5));
		return services.addCuenta(cuenta);
	}
	
	
	@PostMapping(value = "loginCuenta", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	Map<String, Object> loginCuenta(@RequestBody List<String> datosUser) {
		Map<String, Object> mapCuenta = new HashMap<>();
		String email = datosUser.get(0);
		String contrasenya = datosUser.get(1);
		Cuenta cuenta = services.retriveCuentas(email, contrasenya);
		if (cuenta == null) {
			mapCuenta.put("state", "Error");
		}else {
			mapCuenta.put("idCuenta", cuenta.getIdCuenta());
			mapCuenta.put("nombre", cuenta.getNombre());
			mapCuenta.put("apellido Uno", cuenta.getApellidoPrimero());
			mapCuenta.put("apellido dos", cuenta.getApellidoDos());
			mapCuenta.put("username", cuenta.getUsername());
			mapCuenta.put("correo", cuenta.getEmail());
			mapCuenta.put("movil", cuenta.getMovil());
			mapCuenta.put("telefono", cuenta.getTelefono());
			mapCuenta.put("password", cuenta.getPasswd());
			mapCuenta.put("tipo perfil", cuenta.getTipoPerfil());
		}
		return mapCuenta;
	}
	
	@PostMapping(value = "loginCorreo", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	Cuenta loginCorreo(@RequestBody List<String> datosUser) {
		String email = datosUser.get(0);
		System.out.print(email);
		return services.retriveCuentas(email);
	}
	
	@DeleteMapping(value = "deleteCuenta", produces = MediaType.APPLICATION_JSON_VALUE)
	void deleteCuenta(@RequestBody Cuenta cuenta) {
		services.removeCuenta(cuenta);
	}
	
	@DeleteMapping(value = "deleteCuentaId/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	void deleteCuenta(@PathVariable("id") int id) {
		services.removeCuenta(id);
	}
	
	@PutMapping(value = "updateCuenta", consumes = MediaType.APPLICATION_JSON_VALUE)
	void updateCuenta(@RequestBody Cuenta cuenta) {
		services.addCuenta(cuenta);
	}
	
	@PutMapping(value = "updateC", consumes = MediaType.APPLICATION_JSON_VALUE)
    void updateC(@RequestBody Map<String, String> mCuenta) {
        Cuenta cuenta = c.getById(Integer.parseInt(mCuenta.get("idcuenta")));
        for(Map.Entry<String, String> entrada: mCuenta.entrySet()) {
            switch (entrada.getKey()) {
            case "nombre":
                cuenta.setNombre(entrada.getValue());
                break;
            case "apellidoPrimero":
                cuenta.setApellidoPrimero(entrada.getValue());
                break;
            case "apellidoDos":
                cuenta.setApellidoDos(entrada.getValue());
                break;
            case "movil":
                cuenta.setMovil(Integer.parseInt(entrada.getValue()));
                break;
            case "passwd":
                cuenta.setPasswd(entrada.getValue());
                break;
            case "telefono":
                cuenta.setTelefono(Integer.parseInt(entrada.getValue()));
                break;
            case "username":
                cuenta.setUsername(entrada.getValue());
            }
        }
        c.save(cuenta);
    }
	
	
	
	
}
