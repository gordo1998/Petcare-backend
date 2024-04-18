package petcare.service.Interfaces;

import java.util.List;

import petcare.entities.Servicio;

public interface ServicioIntS {
	Servicio retrieveServicio(Servicio servicio);
	Servicio retrieveServicio(int idServicio);
	List<Servicio> retrieveServicios();
}
