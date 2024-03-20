package petcare.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import petcare.entities.Reserva;
@Service
public interface ReservaService {
	void addReserva(int cuidador, int dueño);
	Reserva retrieveOneReserva(int idReserva);
	List<Reserva> retrieveReserva(Reserva reserva);
	List<Reserva> retrieveReserva(int idDueño);
	 
}
