package petcare.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import petcare.entities.Reserva;
@Repository
public class ReservaDaoImp implements ReservaDao{
	@Autowired
	ReservasJpa reservaJpa;

	@Override
	public void addReserva(Reserva reserva) {
		reservaJpa.save(reserva);
	}

}
