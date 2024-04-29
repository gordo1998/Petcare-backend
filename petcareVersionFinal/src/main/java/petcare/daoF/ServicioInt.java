package petcare.daoF;

import java.util.List;

import org.springframework.stereotype.Service;

import petcare.entities.Servicio;
@Service
public interface ServicioInt {
	Servicio retrieveServicio(Servicio servicio);
	Servicio retrieveServicio(int idServicio);
	List<Servicio> retrieveServicios();
}
