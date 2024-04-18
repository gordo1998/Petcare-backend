package petcare.dao.interfaces;

import java.util.List;

import petcare.entities.Cuidador;

public interface CuidadorInt {
	
	void addCuidador(Cuidador cuidador);
	void removeCuidador(Cuidador cuidador);
	void removeCuidador(int idCuidador);
	Cuidador retrieveCuidador(Cuidador cuidador);
	Cuidador retrieveCuidador(int idCuidador);
	List<Cuidador> retrieveCuidadores();
	
	
}
