package petcare.serviceF;

import java.util.List;

import org.springframework.stereotype.Component;

import petcare.entities.Cuidador;
@Component
public interface CuidadorIntS {
	void addCuidador(Cuidador cuidador);
	void removeCuidador(Cuidador cuidador);
	void removeCuidador(int idCuidador);
	Cuidador retrieveCuidador(Cuidador cuidador);
	Cuidador retrieveCuidador(int idCuidador);
	List<Cuidador> retrieveCuidadores();
	void updateAccess(int access, int idCuidador);
	int retrieveAcces(int idCuidador);
}
