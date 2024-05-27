package petcare.daoF;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import petcare.entities.*;
@Repository
public interface ServicioCuidadorJpa extends JpaRepository<Serviciocuidador, ServiciocuidadorPK>{
	@Query("Select s from Serviciocuidador s where s.id.idServicioS = ?1")
	List<Serviciocuidador> retrieveServiciosCuidador(int idServicio);
}
