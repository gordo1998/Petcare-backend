package petcare.daoF;

import java.util.List;

import org.springframework.stereotype.Service;

import petcare.entities.Serviciocuidador;
import petcare.entities.ServiciocuidadorPK;
@Service
public interface ServicioCuidadorInt {
	void addServicioCuidador(Serviciocuidador servicioCuidador);
	void removeServicioCuidador(Serviciocuidador servicioCuidador);
	void removeServicioCuidador(ServiciocuidadorPK idServicio);
	Serviciocuidador retrieveServicioCuidador(Serviciocuidador servicio);
	Serviciocuidador retrieveServicioCuidador(ServiciocuidadorPK servicioCuidadorPK);
	List<Serviciocuidador> retrieveServiciosCuidador(int idCuidador);
}
