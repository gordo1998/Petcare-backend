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

import petcare.daoF.CuidadorJpa;
import petcare.daoF.ServicioCuidadorJpa;
import petcare.entities.Cuenta;
import petcare.entities.Cuidador;
import petcare.entities.Serviciocuidador;
import petcare.entities.ServiciocuidadorPK;
import petcare.serviceF.CuidadorIntS;

@RestController
public class ServicioCuidadorCtr {
	@Autowired
	ServicioCuidadorJpa jpa;
	@Autowired
	CuidadorIntS cuidador;
	
	@GetMapping(value = "getServiciosCuidador/{idServicio}", produces = MediaType.APPLICATION_JSON_VALUE)
	Map<String, List<String>> getlistServCuidadores(@PathVariable("idServicio") int idServicio){
		
		List<Serviciocuidador> cuidadores = jpa.retrieveServiciosCuidador(idServicio);//Aqui tenemos los serviciosCuidador pero no podemos acceder a los cuidadores
		List<ServiciocuidadorPK> idsServCuidador = new ArrayList<>();
		for (Serviciocuidador s: cuidadores) {
			idsServCuidador.add(s.getId());//Sacamos los ids de ServicioCuidador
		}
		
		List<Cuidador> listaCuidadores = new ArrayList<>();
		
		for (ServiciocuidadorPK c: idsServCuidador) {
			
			listaCuidadores.add(cuidador.retrieveCuidador(c.getIdCuidadorS()));
		}
		
		List<Cuenta> listaCuentas = new ArrayList<>();
		
		for (Cuidador y: listaCuidadores) {
			listaCuentas.add(y.getCuenta());
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
