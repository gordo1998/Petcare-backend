package petcare.daoF;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import petcare.entities.*;

@Service
public interface CuidadorJpa extends JpaRepository<Cuidador, Integer>{
	
	@Modifying
	@Query("UPDATE Cuidador c SET c.accesFirstTime = :access WHERE c.idCuidador = :idCuidador")
	void updateAccessFirst(@Param("access") int access, @Param("idCuidador") int idCuidador);
	
	@Query("Select c.accesFirstTime FROM Cuidador c Where c.idCuidador = ?1")
	int retrieveAccess(int idCuidador);
	
	//update cuidador set accesFirstTime = 1 where idCuidador = 1;
}


