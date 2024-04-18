package petcare.dao.reposirtoryJpa;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import petcare.entities.*;

@Repository
public interface MascotaJpa extends JpaRepository<Mascota, Integer>{
	@Query("Select m from Mascota m where m.dueño.idDueño = ?1")
	List<Mascota> retrieveMascotas(int idDueño);
	
}
