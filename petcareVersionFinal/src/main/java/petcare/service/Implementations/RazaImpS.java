package petcare.service.Implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import petcare.dao.Implementations.RazaImp;
import petcare.dao.interfaces.RazaInt;
import petcare.entities.Raza;
import petcare.service.Interfaces.RazaIntS;
@Service
public class RazaImpS implements RazaIntS{

	private RazaImp dao = new RazaImp();
	
	@Override
	public Raza retrieveRaza(Raza raza) {
		if(dao.retrieveRaza(raza.getIdRaza()) != null) {
			return dao.retrieveRaza(raza);
		}
		return null;
	}

	@Override
	public Raza retrieveRaza(int idRaza) {
		if(dao.retrieveRaza(idRaza) != null) {
			return dao.retrieveRaza(idRaza);
		}
		return null;
	}

	@Override
	public List<Raza> retrieveRazas() {
		return dao.retrieveRazas();
	}

}
