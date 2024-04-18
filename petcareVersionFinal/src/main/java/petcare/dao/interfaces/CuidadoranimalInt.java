package petcare.dao.interfaces;

import java.util.List;

import petcare.entities.Cuidadoranimal;
import petcare.entities.CuidadoranimalPK;

public interface CuidadoranimalInt {
	void addCuidadorAnimal(Cuidadoranimal cuidadorAnimal);
	void addCuidadorAnimales(List<Cuidadoranimal> cuidadorAnimales);
	void removeCuidadorAnimal(Cuidadoranimal cuidadorAnimal);
	void removeCuidadorAnimales(List<Cuidadoranimal> cuidadorAnimales);
	void removeCuidadorAnimal(int idAnimal, int idCuidador);
	void removeCuidadorAnimal(CuidadoranimalPK cuidadorAnimalpk);
	Cuidadoranimal retrieveCuidadorAnimal(CuidadoranimalPK cuidadorAnimalpk);
	Cuidadoranimal retrieveCuidadorAnimal(int idAnimal, int idCuidador);
}
