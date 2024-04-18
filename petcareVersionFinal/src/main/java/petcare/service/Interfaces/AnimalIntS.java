package petcare.service.Interfaces;

import java.util.List;

import petcare.entities.Animal;

public interface AnimalIntS {
	Animal retrieveAnimal(Animal animal);
	Animal retrieveAnimal(int idAnimal);
	List<Animal> retrieveAnimales();
}
