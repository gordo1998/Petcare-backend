package petcare.dao.Implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import petcare.dao.interfaces.AnimalInt;
import petcare.dao.reposirtoryJpa.AnimalJpa;
import petcare.entities.Animal;
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
