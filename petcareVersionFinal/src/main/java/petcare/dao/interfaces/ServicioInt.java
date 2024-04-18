package petcare.dao.interfaces;

import java.util.List;

import petcare.entities.Servicio;

public interface ServicioInt {
	Servicio retrieveServicio(Servicio servicio);
	Servicio retrieveServicio(int idServicio);
	List<Servicio> retrieveServicios();
}
