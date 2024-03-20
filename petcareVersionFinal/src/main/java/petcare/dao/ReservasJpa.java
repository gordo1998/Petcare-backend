package petcare.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import petcare.entities.Reserva;
@Service
public interface ReservasJpa extends JpaRepository<Reserva, Integer>{
	@Query("Select r from Reserva r where r.dueño.idDueño = ?1")
	List<Reserva> retrieveReservas(int idDueño);
}