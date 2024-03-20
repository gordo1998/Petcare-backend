package petcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import petcare.dao.ReservaDao;
import petcare.entities.Reserva;
@Service
public class ReservaServiceImp implements ReservaService{
	
	@Autowired
	ReservaDao reservaDao;

	@Override
	public void addReserva(Reserva reserva)  {
		reservaDao.addReserva(reserva);
	}

}
