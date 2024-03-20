package petcare.service;

import org.springframework.stereotype.Service;

import petcare.entities.Reserva;
@Service
public interface ReservaService {
	void addReserva(Reserva reserva);
	 
}
