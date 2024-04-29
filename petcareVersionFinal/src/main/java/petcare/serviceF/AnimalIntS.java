package petcare.serviceF;

import java.util.List;

import org.springframework.stereotype.Component;

import petcare.entities.Animal;
@Component
public interface AnimalIntS {
	Animal retrieveAnimal(Animal animal);
	Animal retrieveAnimal(int idAnimal);
	List<Animal> retrieveAnimales();
}
