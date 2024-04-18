package petcare.service.Implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import petcare.dao.Implementations.ServicioCuidadorImp;
import petcare.dao.interfaces.ServicioCuidadorInt;
import petcare.entities.Serviciocuidador;
import petcare.entities.ServiciocuidadorPK;
import petcare.service.Interfaces.ServicioCuidadorIntS;
@Service
public class ServicioCuidadorImpS implements ServicioCuidadorIntS{

	private ServicioCuidadorImp dao = new ServicioCuidadorImp();
	
	@Override
	public void addServicioCuidador(Serviciocuidador servicioCuidador) {
		dao.addServicioCuidador(servicioCuidador);
	}

	@Override
	public void removeServicioCuidador(Serviciocuidador servicioCuidador) {
		dao.removeServicioCuidador(servicioCuidador);
	}

	@Override
	public void removeServicioCuidador(ServiciocuidadorPK idServicio) {
		dao.removeServicioCuidador(idServicio);
	}

	@Override
	public Serviciocuidador retrieveServicioCuidador(Serviciocuidador servicio) {
		if(dao.retrieveServicioCuidador(servicio.getId()) != null) {
			return dao.retrieveServicioCuidador(servicio);
		}
		return null;
	}

	@Override
	public Serviciocuidador retrieveServicioCuidador(ServiciocuidadorPK servicioCuidadorPK) {
		if(dao.retrieveServicioCuidador(servicioCuidadorPK) != null) {
			return dao.retrieveServicioCuidador(servicioCuidadorPK);
		}
		return null;
	}

	@Override
	public List<Serviciocuidador> retrieveServiciosCuidador(int idCuidador) {
		return dao.retrieveServiciosCuidador(idCuidador);
	}

}
