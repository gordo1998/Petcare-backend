package petcare.service.Interfaces;

import java.util.List;

import petcare.entities.Raza;

public interface RazaIntS {
	Raza retrieveRaza(Raza raza);
	Raza retrieveRaza(int idRaza);
	List<Raza> retrieveRazas();
}
