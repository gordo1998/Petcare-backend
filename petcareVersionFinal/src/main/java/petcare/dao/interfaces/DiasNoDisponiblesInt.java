package petcare.dao.interfaces;

import java.util.List;

import petcare.entities.Dianodisponible;

public interface DiasNoDisponiblesInt {
	void addDiaNoDisponible(Dianodisponible diaNoDisponible);
	void addDiasNoDisponibles(List<Dianodisponible> diasNoDisponibles);
	void removeDiaNoDisponible(Dianodisponible diaNoDisponible);
	void removeDiaNoDisponible(int idDiaNoDisponible);
	void removeDiasNoDisponiblesByObject(List<Dianodisponible> diasNoDisponibles);
	void removeDiasNoDisponiblesByIds(List<Integer> diasNoDisponibles);
	Dianodisponible retrieveDiaNoDisponible(Dianodisponible diaNoDisponible);
	Dianodisponible retrieveDiaNoDisponible(int idDiaNoDisponible);
	List<Dianodisponible> retrieveDiasNoDisponibles(int idCudiador);
	
	
}
