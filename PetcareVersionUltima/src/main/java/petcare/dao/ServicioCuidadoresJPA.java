package petcare.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import petcare.entities.Serviciocuidador;
import petcare.entities.ServiciocuidadorPK;

@Service
public interface ServicioCuidadoresJPA extends JpaRepository<Serviciocuidador, ServiciocuidadorPK>{
	@Query("Select s from serviciocuidador s where s.idServicio = ?1")
	List<Serviciocuidador> gerServicioCuidador(int servicio);
}
