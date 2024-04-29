package petcare.daoF;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import petcare.entities.Raza;
public class RazaImp implements RazaInt {

	
	@Autowired
	RazaJpa jpa;
	
	@Override
	public Raza retrieveRaza(Raza raza) {
		return jpa.findById(raza.getIdRaza()).orElse(null);
	}

	@Override
	public Raza retrieveRaza(int idRaza) {
		return jpa.findById(idRaza).orElse(null);
	}

	@Override
	public List<Raza> retrieveRazas() {
		return jpa.findAll();
	}

}
