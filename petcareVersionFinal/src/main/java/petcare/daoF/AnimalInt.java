package petcare.daoF;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import petcare.entities.Animal;
@Service
public interface AnimalInt {
	
	Animal retrieveAnimal(Animal animal);
	Animal retrieveAnimal(int idAnimal);
	List<Animal> retrieveAnimales();
	//SE PUEDE COMPLETAR
	
}
