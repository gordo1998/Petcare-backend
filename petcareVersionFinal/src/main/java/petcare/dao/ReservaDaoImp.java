package petcare.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import petcare.entities.Cuidador;
import petcare.entities.Reserva;
@Repository
public class ReservaDaoImp implements ReservaDao{
	@Autowired
	ReservasJpa reservaJpa;

	@Override
	public void addReserva(int idCuidador, int idDueño) {
		Reserva reserva = new Reserva();
		Cuidador cuidador = new Cuidador();
		cuidador.setIdCuidador(idCuidador);
		
		petcare.entities.Dueño dueño = new petcare.entities.Dueño();
		dueño.setIdDueño(idDueño);
		
		reserva.setCuidador(cuidador);
		reserva.setDueño(dueño);
		reservaJpa.save(reserva);
	}

	@Override
	public List<Reserva> retrieveReserva(Reserva reserva) {
		return null;
	}

	@Override
	public List<Reserva> retrieveReserva(int idDueño) {
		
		return reservaJpa.retrieveReservas(idDueño);
	}

	@Override
	public Reserva retrieveOneReserva(int idReserva) {
		return reservaJpa.getReferenceById(idReserva);
	}
	
	

}
