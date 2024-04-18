package petcare.service.Implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import petcare.dao.Implementations.ServicioImp;
import petcare.dao.interfaces.ServicioInt;
import petcare.entities.Servicio;
import petcare.service.Interfaces.ServicioIntS;
@Service
public class ServicioImpS implements ServicioIntS{

	private ServicioImp dao = new ServicioImp();
	
	@Override
	public Servicio retrieveServicio(Servicio servicio) {
		if(dao.retrieveServicio(servicio.getIdServicio()) != null) {
			return dao.retrieveServicio(servicio);
		}
		return null;
	}

	@Override
	public Servicio retrieveServicio(int idServicio) {
		if(dao.retrieveServicio(idServicio) != null) {
			return dao.retrieveServicio(idServicio);
		}
		return null;
	}

	@Override
	public List<Servicio> retrieveServicios() {
		return dao.retrieveServicios();
	}

}
