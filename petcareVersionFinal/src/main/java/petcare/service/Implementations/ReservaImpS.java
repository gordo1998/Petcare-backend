package petcare.service.Implementations;

import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import petcare.dao.interfaces.ReservaInt;
import petcare.entities.Reserva;
import petcare.service.Interfaces.ReservaIntS;

public class ReservaImpS implements ReservaIntS{

	@Autowired
	ReservaInt dao;
	
	@Override
	public void addReserva(Reserva reserva) {
		dao.addReserva(reserva);
	}
	
	@Override
	public void addReserva(int idCuidador, int idDueño) {
		dao.addReserva(idCuidador, idDueño);
	}

	@Override
	public void removeReserva(Reserva reserva) {
		dao.removeReserva(reserva);
	}

	@Override
	public void removeReserva(int idReserva) {
		dao.removeReserva(idReserva);
	}

	@Override
	public Reserva retrieveReserva(Reserva reserva) {
		if(dao.retrieveReserva(reserva.getIdReserva()) != null) {
			return dao.retrieveReserva(reserva);
		}
		return null;
	}

	@Override
	public Reserva retrieveReserva(int idReserva) {
		if(dao.retrieveReserva(idReserva) != null) {
			return dao.retrieveReserva(idReserva);
		}
		return null;
	}

	@Override
	public boolean retrieveReserva(int mes, int dia, Time hora) {
		if(dao.retrieveReserva(mes, dia, hora) != null) {
			return true;
		}
		return false;
	}

	@Override
	public List<Reserva> retrieveReservasByDueño(int idDueño) {
		return dao.retrieveReservasByDueño(idDueño);
	}

	@Override
	public List<Reserva> retrieveReservasByCuidador(int idCuidador) {
		return dao.retrieveReservasByCuidador(idCuidador);
	}

}
