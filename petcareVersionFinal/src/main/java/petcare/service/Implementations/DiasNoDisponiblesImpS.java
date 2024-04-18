package petcare.service.Implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import petcare.dao.Implementations.DiasNoDisponiblesImp;
import petcare.dao.interfaces.DiasNoDisponiblesInt;
import petcare.entities.Dianodisponible;
import petcare.service.Interfaces.DiasNoDisponiblesIntS;
@Service
public class DiasNoDisponiblesImpS implements DiasNoDisponiblesIntS{

	private DiasNoDisponiblesImp dao = new DiasNoDisponiblesImp();
	
	@Override
	public boolean addDiaNoDisponible(Dianodisponible diaNoDisponible) {
		if(dao.retrieveDiaNoDisponible(diaNoDisponible.getIdDiasNoDisponible()) == null) {
			dao.addDiaNoDisponible(diaNoDisponible);
		}
		return false;
	}

	@Override
	public boolean addDiasNoDisponibles(List<Dianodisponible> diasNoDisponibles) {
		for(Dianodisponible dnd: diasNoDisponibles) {
			if(dao.retrieveDiaNoDisponible(dnd.getIdDiasNoDisponible()) == null) {
				dao.addDiaNoDisponible(dnd);
			}else {
				return false;
			}
		}
		return true;
	}

	@Override
	public void removeDiaNoDisponible(Dianodisponible diaNoDisponible) {
		dao.removeDiaNoDisponible(diaNoDisponible);
	}

	@Override
	public void removeDiaNoDisponible(int idDiaNoDisponible) {
		dao.removeDiaNoDisponible(idDiaNoDisponible);
	}

	@Override
	public void removeDiasNoDisponiblesByObject(List<Dianodisponible> diasNoDisponibles) {
		for(Dianodisponible dnd: diasNoDisponibles) {
			dao.removeDiaNoDisponible(dnd);
		}
	}

	@Override
	public void removeDiasNoDisponiblesByIds(List<Integer> diasNoDisponibles) {
		for(Integer dnd: diasNoDisponibles) {
			dao.removeDiaNoDisponible(dnd);
		}
	}

	@Override
	public Dianodisponible retrieveDiaNoDisponible(Dianodisponible diaNoDisponible) {
		if(dao.retrieveDiaNoDisponible(diaNoDisponible.getIdDiasNoDisponible()) != null) {
			dao.retrieveDiaNoDisponible(diaNoDisponible);
		}
		return null;
	}

	@Override
	public Dianodisponible retrieveDiaNoDisponible(int idDiaNoDisponible) {
		if(dao.retrieveDiaNoDisponible(idDiaNoDisponible) != null) {
			return dao.retrieveDiaNoDisponible(idDiaNoDisponible);
		}
		return null;
	}

	@Override
	public List<Dianodisponible> retrieveDiasNoDisponibles(int idCudiador) {
		return dao.retrieveDiasNoDisponibles(idCudiador);
	}

}
