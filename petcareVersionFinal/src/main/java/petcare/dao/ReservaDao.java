package petcare.dao;

import java.util.List;
import java.util.Optional;

import petcare.entities.Reserva;

public interface ReservaDao {
	void addReserva(int idCuidador, int idDueño);
	Reserva retrieveOneReserva(int idReserva);
	List<Reserva> retrieveReserva(Reserva reserva);
	List<Reserva> retrieveReserva(int idDueño);
}
