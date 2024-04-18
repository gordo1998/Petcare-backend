package petcare.dao.Implementations;

import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import petcare.dao.interfaces.ReservaInt;
import petcare.dao.reposirtoryJpa.ReservaJpa;
import petcare.entities.Reserva;
import petcare.entities.Cuidador;
import petcare.entities.Dueño;
public class ReservaImp implements ReservaInt {
	
	@Autowired
	ReservaJpa jpa;
	
	@Override
	public void addReserva(Reserva reserva) {
		jpa.save(reserva);
	}
	
	@Override
	public void addReserva(int idcuidador, int iddueño) {
		Reserva reserva = new Reserva();
		Cuidador cuidador = new Cuidador();
		Dueño dueño = new Dueño();
		cuidador.setIdCuidador(idcuidador);
		dueño.setIdDueño(iddueño);
		reserva.setCuidador(cuidador);
		reserva.setDueño(dueño);
		jpa.save(reserva);
	}

	@Override
	public void removeReserva(Reserva reserva) {
		jpa.delete(reserva);
	}

	@Override
	public void removeReserva(int idReserva) {
		jpa.deleteById(idReserva);
	}

	@Override
	public Reserva retrieveReserva(Reserva reserva) {
		return jpa.findById(reserva.getIdReserva()).orElse(null);
	}

	@Override
	public Reserva retrieveReserva(int idReserva) {
		return jpa.findById(idReserva).orElse(null);
	}
	
	public Reserva retrieveReserva(int mes, int dia, Time hora) {
		return jpa.retrieveReserva(mes, dia, hora);
	}

	@Override
	public List<Reserva> retrieveReservasByDueño(int idDueño) {
		return jpa.retrieveReservasByDueño(idDueño);
	}

	@Override
	public List<Reserva> retrieveReservasByCuidador(int idCuidador) {
		return jpa.retrieveReservasByCuidador(idCuidador);
	}

}
