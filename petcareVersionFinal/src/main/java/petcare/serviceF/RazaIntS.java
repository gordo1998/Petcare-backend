package petcare.serviceF;

import java.util.List;

import org.springframework.stereotype.Component;

import petcare.entities.Raza;
@Component
public interface RazaIntS {
	Raza retrieveRaza(Raza raza);
	Raza retrieveRaza(int idRaza);
	List<Raza> retrieveRazas();
}
