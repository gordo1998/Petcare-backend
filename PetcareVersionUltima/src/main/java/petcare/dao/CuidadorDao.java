package petcare.dao;

import java.util.List;

import petcare.entities.Cuidador;

public interface CuidadorDao {
	void addCuidador(Cuidador cuidador);
	void removeCuidador(Cuidador cuidador);
	void removeCuidador(int primaryKey);
	List<Cuidador> getCuidadores();
	Cuidador retrieveCuidador(Cuidador cuidador);
	Cuidador retrieveCuidador(int primaryKey);
	Cuidador retrieveCuidador(String nombre);
	
	
}
