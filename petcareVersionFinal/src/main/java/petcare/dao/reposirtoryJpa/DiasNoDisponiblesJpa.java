package petcare.dao.reposirtoryJpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import petcare.entities.*;

@Repository
public interface DiasNoDisponiblesJpa extends JpaRepository<Dianodisponible, Integer>{
	
	@Query("Select d from Dianodisponible d where d.cuidadorDiaNoDisponible.idCuidador = ?1")
	List<Dianodisponible> retrieveDiasNoDisponibles(int idCuidador);
}
