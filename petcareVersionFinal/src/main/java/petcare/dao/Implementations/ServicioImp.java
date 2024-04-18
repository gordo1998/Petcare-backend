package petcare.dao.Implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import petcare.dao.interfaces.ServicioInt;
import petcare.dao.reposirtoryJpa.ServicioJpa;
import petcare.entities.Servicio;
public class ServicioImp implements ServicioInt {
	
	@Autowired
	ServicioJpa jpa;

	@Override
	public Servicio retrieveServicio(Servicio servicio) {
		return jpa.findById(servicio.getIdServicio()).orElse(null);
	}

	@Override
	public Servicio retrieveServicio(int idServicio) {
		return jpa.findById(idServicio).orElseGet(null);
	}

	@Override
	public List<Servicio> retrieveServicios() {
		return jpa.findAll();
	}

}
