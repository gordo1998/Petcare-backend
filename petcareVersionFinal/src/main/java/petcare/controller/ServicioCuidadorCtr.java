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

import petcare.daoF.AnimalJpa;
import petcare.daoF.CuidadorJpa;
import petcare.daoF.CuidadoranimalJpa;
import petcare.daoF.ServicioCuidadorJpa;
import petcare.entities.Animal;
import petcare.entities.Cuenta;
import petcare.entities.Cuidador;
import petcare.entities.Cuidadoranimal;
import petcare.entities.CuidadoranimalPK;
import petcare.entities.Serviciocuidador;
import petcare.entities.ServiciocuidadorPK;
import petcare.serviceF.CuidadorIntS;

@RestController
public class ServicioCuidadorCtr {
	@Autowired
	ServicioCuidadorJpa jpa;
	@Autowired
	CuidadorJpa cuidador;
	@Autowired
	CuidadoranimalJpa cAnimal;
	@Autowired 
	AnimalJpa animal;
	
	
	
	@GetMapping(value = "getServiciosCuidador/{idServicio}", produces = MediaType.APPLICATION_JSON_VALUE)
	Map<String, List<String>> getlistServCuidadores(@PathVariable("idServicio") int idServicio){
		
		List<Serviciocuidador> cuidadores = jpa.retrieveServiciosCuidador(idServicio);//Aqui tenemos los serviciosCuidador pero no podemos acceder a los cuidadores
		List<ServiciocuidadorPK> idsServCuidador = new ArrayList<>();
		for (Serviciocuidador s: cuidadores) {
			idsServCuidador.add(s.getId());//Sacamos los ids de ServicioCuidador
		}
		
		List<Cuidador> listaCuidadores = new ArrayList<>();
		
		for (ServiciocuidadorPK c: idsServCuidador) {
			Cuidador ce = cuidador.getById(c.getIdCuidadorS());
			listaCuidadores.add(ce);//Aqui añadimos el cuidador en una lista donde estarán todos los cuidadores
		}
		
		List<Cuenta> listaCuentas = new ArrayList<>();
		
		for (Cuidador y: listaCuidadores) {
			Cuenta cuen = y.getCuenta();
			listaCuentas.add(cuen);
		}
		
		Map<String, List<String>> mapString = new HashMap<>();
		
		int i = 0;
		for (Cuenta z: listaCuentas) {
			//listaString.add()
			
			Cuidador c = cuidador.getById(z.getIdCuenta());
			List<Cuidadoranimal> animalesCuidador = cAnimal.retrievesAnimalesCuidador(c.getIdCuidador());
			List<Animal> animales = new ArrayList<>();
			for (Cuidadoranimal ca: animalesCuidador) {
				CuidadoranimalPK idCuidadorAnimal = ca.getId();
				Animal anim = animal.getById(idCuidadorAnimal.getIdAnimalC());
				animales.add(anim);
			}
			List<String> lista = new ArrayList<>();
			lista.add(z.getNombre());
			lista.add(z.getApellidoPrimero());
			lista.add(z.getApellidoDos());
			lista.add(String.valueOf(z.getIdCuenta()));
			lista.add(z.getUsername());
			lista.add(listaCuidadores.get(i).getDescripcionCorta());
			lista.add(listaCuidadores.get(i).getDescripcion());
			for (Animal a: animales) {
				lista.add(a.getNombre());
			}
			mapString.put((z.getNombre() + " " + z.getApellidoPrimero() + " " + z.getApellidoDos()), lista); // --> En la lista tengo que añadir los servicio cuidador
			i++;
		}
		
		return mapString;
	}
}
