package petcare.daoF;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import petcare.entities.*;

@Service
public interface CuidadorJpa extends JpaRepository<Cuidador, Integer>{
	
	@Query("UPDATE Cuidador c SET c.accesFirstTime = ?1 WHERE c.idCuidador = ?2")
	void updateAccessFirst(int access, int idCuidador);
	
	@Query("Select c.accesFirstTime FROM Cuidador c Where c.idCuidador = ?1")
	int retrieveAccess(int idCuidador);
}


