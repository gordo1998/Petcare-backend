package petcare.serviceF;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import petcare.daoF.RazaImp;
import petcare.daoF.RazaInt;
import petcare.entities.Raza;
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
