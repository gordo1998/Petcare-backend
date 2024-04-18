package petcare.dao.reposirtoryJpa;
import java.sql.Time;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import petcare.entities.*;
@Repository
public interface ReservaJpa extends JpaRepository<Reserva, Integer>{
	@Query("Select r from Reserva r where r.dueño.idDueño = ?1")
	List<Reserva> retrieveReservasByDueño(int idDueño);
	
	@Query("Select r from Reserva r where r.cuidador.idCuidador = ?1")
	List<Reserva> retrieveReservasByCuidador(int idCuidador);
	
	@Query("Select r from Reserva r where r.mes = ?1 and r.dia = ?2 and r.hora = ?3")
	Reserva retrieveReserva(int mes, int dia, Time hora);
}
