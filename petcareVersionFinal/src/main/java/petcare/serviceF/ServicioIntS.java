package petcare.serviceF;

import java.util.List;

import org.springframework.stereotype.Component;

import petcare.entities.Servicio;
@Component
public interface ServicioIntS {
	Servicio retrieveServicio(Servicio servicio);
	Servicio retrieveServicio(int idServicio);
	List<Servicio> retrieveServicios();
}
