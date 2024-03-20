package petcare.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import petcare.dao.ReservaDao;
import petcare.entities.Reserva;
@Service
public class ReservaServiceImp implements ReservaService{
	
	@Autowired
	ReservaDao reservaDao;

	@Override
	public void addReserva(int cuidador, int dueño)  {
		reservaDao.addReserva(cuidador, dueño);
	}

	@Override
	public List<Reserva> retrieveReserva(Reserva reserva) {
		return null;
	}

	@Override
	public List<Reserva> retrieveReserva(int idDueño) {
		return reservaDao.retrieveReserva(idDueño);
	}

	@Override
	public Reserva retrieveOneReserva(int idReserva) {
		return reservaDao.retrieveOneReserva(idReserva);
	}

}
