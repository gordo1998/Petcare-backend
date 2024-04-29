package petcare.serviceF;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import petcare.daoF.ServicioImp;
import petcare.daoF.ServicioInt;
import petcare.entities.Servicio;
@Service
public class ServicioImpS implements ServicioIntS{

	@Autowired
	ServicioInt dao;
	
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
