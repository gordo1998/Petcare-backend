package petcare.service.Implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import petcare.entities.Animal;
import petcare.dao.Implementations.AnimalImp;
import petcare.dao.interfaces.AnimalInt;
import petcare.service.Interfaces.AnimalIntS;
@Service
public class AnimalImpS implements AnimalIntS{

	private AnimalImp dao = new AnimalImp();
	
	@Override
	public Animal retrieveAnimal(Animal animal) {
		return dao.retrieveAnimal(animal);
	}

	@Override
	public Animal retrieveAnimal(int idAnimal) {
		return dao.retrieveAnimal(idAnimal);
	}

	@Override
	public List<Animal> retrieveAnimales() {
		return dao.retrieveAnimales();
	}
	
}
