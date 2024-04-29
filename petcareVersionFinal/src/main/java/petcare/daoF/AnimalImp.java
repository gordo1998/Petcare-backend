package petcare.daoF;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import petcare.entities.Animal;
@Repository
public class AnimalImp implements AnimalInt{
	
	@Autowired
	AnimalJpa jpa;

	@Override
	public Animal retrieveAnimal(Animal animal) {
		return jpa.findById(animal.getIdAnimal()).orElse(null);
	}

	@Override
	public Animal retrieveAnimal(int idAnimal) {
		return jpa.findById(idAnimal).orElse(null);
	}

	@Override
	public List<Animal> retrieveAnimales() {
		return jpa.findAll();
	}

}
