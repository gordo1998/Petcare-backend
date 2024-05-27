package petcare.daoF;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import petcare.entities.Serviciocuidador;
import petcare.entities.ServiciocuidadorPK;

@Repository
public class ServicioCuidadorImp implements ServicioCuidadorInt {

	@Autowired
	ServicioCuidadorJpa jpa;
	
	@Override
	public void addServicioCuidador(Serviciocuidador servicioCuidador) {
		jpa.save(servicioCuidador);
	}

	@Override
	public void removeServicioCuidador(Serviciocuidador servicioCuidador) {
		jpa.delete(servicioCuidador);
	}

	@Override
	public void removeServicioCuidador(ServiciocuidadorPK idServicio) {
		jpa.deleteById(idServicio);
	}

	@Override
	public Serviciocuidador retrieveServicioCuidador(Serviciocuidador servicio) {
		return jpa.findById(servicio.getId()).orElse(null);
	}

	@Override
	public Serviciocuidador retrieveServicioCuidador(ServiciocuidadorPK servicioCuidadorPK) {
		return jpa.findById(servicioCuidadorPK).orElse(null);
	}

	@Override
	public List<Serviciocuidador> retrieveServiciosCuidador(int idDueño) {
		return jpa.retrieveServiciosCuidador(idDueño);
	}

}
