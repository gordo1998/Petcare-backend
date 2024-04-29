package petcare.serviceF;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import petcare.entities.Animal;
import petcare.daoF.AnimalImp;
import petcare.daoF.AnimalInt;
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
