package petcare.dao.interfaces;

import java.util.List;

import petcare.entities.Raza;

public interface RazaInt {
	Raza retrieveRaza(Raza raza);
	Raza retrieveRaza(int idRaza);
	List<Raza> retrieveRazas();
}
