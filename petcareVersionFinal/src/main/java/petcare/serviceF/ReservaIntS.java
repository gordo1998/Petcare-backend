package petcare.serviceF;

import java.sql.Time;
import java.util.List;

import org.springframework.stereotype.Component;

import petcare.entities.Reserva;
@Component
public interface ReservaIntS {
	void addReserva(Reserva reserva);
	void addReserva(int cuidador, int dueño);
	void removeReserva(Reserva reserva);
	void removeReserva(int idReserva);
	Reserva retrieveReserva(Reserva reserva);
	Reserva retrieveReserva(int idReserva);
	boolean retrieveReserva(int mes, int dia, Time hora); // --> Es booleano porque quiero que me devuelva si existe o no
	List<Reserva> retrieveReservasByDueño(int idDueño);
	List<Reserva> retrieveReservasByCuidador(int idCuidador);
}
