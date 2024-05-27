package petcare.serviceF;

import java.util.List;

import petcare.entities.Dianodisponible;

public interface DiasNoDisponiblesIntS {
	boolean addDiaNoDisponible(Dianodisponible diaNoDisponible);
	boolean addDiasNoDisponibles(List<Dianodisponible> diasNoDisponibles);//Mirar de que en el front se pueda evitar clicar en las ya marcadas
	void removeDiaNoDisponible(Dianodisponible diaNoDisponible);
	void removeDiaNoDisponible(int idDiaNoDisponible);
	void removeDiasNoDisponiblesByObject(List<Dianodisponible> diasNoDisponibles);
	void removeDiasNoDisponiblesByIds(List<Integer> diasNoDisponibles);
	Dianodisponible retrieveDiaNoDisponible(Dianodisponible diaNoDisponible);
	Dianodisponible retrieveDiaNoDisponible(int idDiaNoDisponible);
	List<Dianodisponible> retrieveDiasNoDisponibles(int idCudiador);
}
