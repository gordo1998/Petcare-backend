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

import petcare.entities.Cuenta;
import petcare.entities.Cuidador;
import petcare.entities.Servicio;
import petcare.entities.Serviciocuidador;
import petcare.service.Implementations.CuentaImpS;
import petcare.service.Implementations.CuidadorImpS;
import petcare.service.Implementations.ServicioCuidadorImpS;
import petcare.service.Interfaces.CuentaIntS;
import petcare.service.Interfaces.CuidadorIntS;
import petcare.service.Interfaces.ServicioCuidadorIntS;

@RestController
public class ServicioCuidadorCtr {

	private ServicioCuidadorImpS services = new ServicioCuidadorImpS();
	private CuidadorImpS c = new CuidadorImpS();
	private CuentaImpS cu = new CuentaImpS();
	
	@GetMapping(value = "getServiciosCuidador/{idServicio}", produces = MediaType.APPLICATION_JSON_VALUE)
	Map<String, List<String>> getlistServCuidadores(@PathVariable("idServicio") int idServicio){
		
		List<Serviciocuidador> cuidadores = services.retrieveServiciosCuidador(idServicio);//Aqui estan todos los cuidadores que hacen un servicio en concreto
		List<Integer> listaCuidadoresIds = new ArrayList<>(); //cada id representa un cuidador
		for (Serviciocuidador c: cuidadores) {
			listaCuidadoresIds.add(c.getId().getIdCuidadorS());//Aqui introduzco los ids
		}
		
		
		List<Cuidador> listaCuidadores = new ArrayList<>();
		for(Integer lc: listaCuidadoresIds) {
			listaCuidadores.add(c.retrieveCuidador(idServicio));			
		}
		
		List<Cuenta> listaCuentas = new ArrayList<>();
		for (Cuidador c: listaCuidadores) {
			listaCuentas.add(cu.retriveCuentas(c.getIdCuidador()));
		}
		
		Map<String, List<String>> mapString = new HashMap<>();
		
		
		for (Cuenta z: listaCuentas) {
			//listaString.add()
			List<String> lista = new ArrayList<>();
			lista.add(z.getNombre());
			lista.add(z.getApellidoPrimero());
			lista.add(z.getApellidoDos());
			lista.add(String.valueOf(z.getIdCuenta()));
			mapString.put((z.getNombre() + " " + z.getApellidoPrimero() + " " + z.getApellidoDos()), lista); // --> En la lista tengo que añadir los servicio cuidador
		}
		
		return mapString;
	}
}
