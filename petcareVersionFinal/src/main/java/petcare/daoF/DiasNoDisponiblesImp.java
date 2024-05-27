package petcare.daoF;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import petcare.entities.Dianodisponible;
public class DiasNoDisponiblesImp implements DiasNoDisponiblesInt {
	
	@Autowired
	DiasNoDisponiblesJpa jpa;

	@Override
	public void addDiaNoDisponible(Dianodisponible diaNoDisponible) {
		jpa.save(diaNoDisponible);
	}

	@Override
	public void addDiasNoDisponibles(List<Dianodisponible> diasNoDisponibles) {
		for (Dianodisponible dnp: diasNoDisponibles) {
			jpa.save(dnp);
		}
	}
	

	@Override
	public void removeDiaNoDisponible(Dianodisponible diaNoDisponible) {
		jpa.delete(diaNoDisponible);
	}
	
	public void removeDiaNoDisponible(int idDiaNoDisponible) {
		jpa.deleteById(idDiaNoDisponible);
	}

	@Override
	public void removeDiasNoDisponiblesByObject(List<Dianodisponible> diasNoDisponibles) {
		for(Dianodisponible dnp: diasNoDisponibles) {
			jpa.delete(dnp);
		}
	}
	
	public void removeDiasNoDisponiblesByIds(List<Integer> diasNoDisponibles) {
		for (Integer dnp: diasNoDisponibles) {
			jpa.deleteById(dnp);
		}
	}

	@Override
	public Dianodisponible retrieveDiaNoDisponible(Dianodisponible diaNoDisponible) {
		return jpa.findById(diaNoDisponible.getIdDiasNoDisponible()).orElse(null);
	}

	@Override
	public Dianodisponible retrieveDiaNoDisponible(int idDiaNoDisponible) {
		return jpa.findById(idDiaNoDisponible).orElse(null);
	}

	@Override
	public List<Dianodisponible> retrieveDiasNoDisponibles(int idCudiador) {
		return jpa.retrieveDiasNoDisponibles(idCudiador);
	}

}
