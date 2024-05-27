package petcare.daoF;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import petcare.entities.*;

@Repository
public interface RazaJpa extends JpaRepository<Raza, Integer>{
	
	@Query("Select r from Raza r where r.animal.idAnimal = ?1")
	public List<Raza> getRazaByAnimal(int idAnimal);
}
