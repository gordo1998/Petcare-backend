package petcare.daoF;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import petcare.entities.*;

@Repository
public interface CuidadoranimalJpa extends JpaRepository<Cuidadoranimal, CuidadoranimalPK>{
	
	@Query("Select c from Cuidadoranimal c where c.id.idAnimalC = ?1 and c.id.idCuidadorC = ?2")
	Cuidadoranimal retrieveCuidadorAnimal(int idAnimal, int idCuidador);
	
	@Query("Delete from Cuidadoranimal c where c.id.idAnimalC = ?1 and c.id.idCuidadorC = ?2")
	void removeCuidadorAnimal(int idAnimal, int idCuidador);
}
