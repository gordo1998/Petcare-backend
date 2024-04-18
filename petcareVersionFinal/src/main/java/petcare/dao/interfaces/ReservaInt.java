package petcare.dao.interfaces;

import java.sql.Time;
import java.util.List;

import petcare.entities.Reserva;

public interface ReservaInt {
	void addReserva(Reserva reserva);
	void addReserva(int cuidador, int dueño);
	void removeReserva(Reserva reserva);
	void removeReserva(int idReserva);
	Reserva retrieveReserva(Reserva reserva);
	Reserva retrieveReserva(int idReserva);
	Reserva retrieveReserva(int mes, int dia, Time hora);
	List<Reserva> retrieveReservasByDueño(int idDueño);
	List<Reserva> retrieveReservasByCuidador(int idCuidador);
	
}
