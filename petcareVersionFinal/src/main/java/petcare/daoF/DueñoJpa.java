package petcare.daoF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import petcare.entities.*;

@Repository
public interface DueñoJpa extends JpaRepository<Dueño, Integer>{

	@Query("Select d.accesFirstTime FROM Dueño d Where d.idDueño = ?1")
	public int numberTime(int idDueño);
}
