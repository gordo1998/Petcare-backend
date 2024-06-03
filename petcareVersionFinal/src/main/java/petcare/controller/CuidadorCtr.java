package petcare.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import petcare.daoF.CuentaJpa;
import petcare.daoF.CuidadorJpa;
import petcare.daoF.CuidadoranimalJpa;
import petcare.daoF.ServicioCuidadorJpa;
import petcare.entities.Cuenta;
import petcare.entities.Cuidador;
import petcare.entities.Cuidadoranimal;
import petcare.entities.CuidadoranimalPK;
import petcare.entities.Dueño;
import petcare.entities.Serviciocuidador;
import petcare.entities.ServiciocuidadorPK;
import petcare.serviceF.CuentaIntS;
import petcare.serviceF.CuidadorIntS;

@RestController
public class CuidadorCtr {
	
	@Autowired
	CuidadorJpa jpa;
	
	@Autowired
	CuentaJpa cuenta;
	
	@Autowired
	ServicioCuidadorJpa sCuidadorJpa;
	
	@Autowired
	CuidadoranimalJpa cAnimalJpa;
	
	
	@GetMapping(value = "getCuidadores/{idServicio}", produces = MediaType.APPLICATION_JSON_VALUE)
	List<Cuidador> getCuidadores(@PathVariable("idServicio") int idServicio) {
		
		return jpa.findAll();
	}
	
	@GetMapping(value = "getCuidador/{idCuidador}")
	public Map<String, Object> getCuidador(@PathVariable("idCuidador") int idCuidador){
		Cuidador cuidador = jpa.getById(idCuidador);
		Cuenta gCuenta = cuenta.getById(cuidador.getIdCuidador());
		Map<String, Object> mCuidador = new HashMap<>();
		mCuidador.put("idCuidador", cuidador.getIdCuidador());
		mCuidador.put("nombre", gCuenta.getNombre());
		mCuidador.put("primer apellido", gCuenta.getApellidoPrimero());
		mCuidador.put("segundo apellido", gCuenta.getApellidoDos());
		mCuidador.put("username", gCuenta.getUsername());
		mCuidador.put("movil", gCuenta.getMovil());
		mCuidador.put("telefono", gCuenta.getTelefono());
		mCuidador.put("descripcion corta", cuidador.getDescripcionCorta());
		mCuidador.put("descripcion", cuidador.getDescripcion());
		mCuidador.put("servicios", cuidador.getServicios());
		mCuidador.put("animales", cuidador.getAnimals());
		return mCuidador;
	}
	
	@PutMapping(value = "addCuidadorAcces/{idCuidador}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void accessLogin(@PathVariable("idCuidador") int idCuidador) {
		
		
	
		if(jpa.retrieveAccess(idCuidador) <= 0) {
			//jpa.updateAccessFirst(1, idCuidador);
			Cuidador c = jpa.getById(idCuidador);
			c.setAccesFirstTime(1);
		}
		Cuidador c = jpa.getById(idCuidador);
		c.setAccesFirstTime(1);
		jpa.save(c);
		
		
		
	}
	
	@GetMapping(value = "getAccesTimes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	int getAccesTime(@PathVariable("id") int a) {
		return jpa.retrieveAccess(a);
	}
	
	
	@PutMapping(value = "upCuidador")
	public void uCuidador(@RequestBody Map<String, Object> cu) {
		
		Cuidador d = jpa.getById((Integer) cu.get("idCuidador"));
		//d.setAccesFirstTime(0);
		String desCorta = (String) cu.get("Descripcion");
		d.setDescripcion((String) cu.get("Descripcion"));
		d.setDescripcionCorta(desCorta.substring(0, 50));
		jpa.save(d);
		for(Integer i: (List<Integer>) cu.get("servicios")) {
			Serviciocuidador sCuidador = new Serviciocuidador();
			ServiciocuidadorPK idSCuidador = new ServiciocuidadorPK();
			idSCuidador.setIdCuidadorS((Integer) cu.get("idCuidador"));
			idSCuidador.setIdServicioS(i);
			sCuidador.setId(idSCuidador);
			sCuidadorJpa.save(sCuidador);
		}
		
		for(Integer s: (List<Integer>) cu.get("animales")) {
			Cuidadoranimal cuidadorAnimal = new Cuidadoranimal();
			CuidadoranimalPK idCuidadorAnimal = new CuidadoranimalPK();
			idCuidadorAnimal.setIdCuidadorC((Integer) cu.get("idCuidador"));
			idCuidadorAnimal.setIdAnimalC(s);
			cuidadorAnimal.setId(idCuidadorAnimal);
			cAnimalJpa.save(cuidadorAnimal);
		}		
	}
	
	
	
	

	
}
