package petcare.daoF;

import java.util.List;

import org.springframework.stereotype.Service;

import petcare.entities.Cuidador;
@Service
public interface CuidadorInt {
	
	void addCuidador(Cuidador cuidador);
	void removeCuidador(Cuidador cuidador);
	void removeCuidador(int idCuidador);
	Cuidador retrieveCuidador(Cuidador cuidador);
	Cuidador retrieveCuidador(int idCuidador);
	List<Cuidador> retrieveCuidadores();
	void updateAccesFirst(int acces, int idCuidador);
	int retrieveAccess(int idCuidador);
	
	
}
