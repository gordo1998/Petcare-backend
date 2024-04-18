package petcare.dao.interfaces;

import java.util.List;

import org.springframework.stereotype.Repository;

import petcare.entities.Animal;
@Repository
public interface AnimalInt {
	
	Animal retrieveAnimal(Animal animal);
	Animal retrieveAnimal(int idAnimal);
	List<Animal> retrieveAnimales();
	//SE PUEDE COMPLETAR
	
}
