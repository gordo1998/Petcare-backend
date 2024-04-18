package petcare.dao.interfaces;

import java.util.List;

import petcare.entities.Serviciocuidador;
import petcare.entities.ServiciocuidadorPK;

public interface ServicioCuidadorInt {
	void addServicioCuidador(Serviciocuidador servicioCuidador);
	void removeServicioCuidador(Serviciocuidador servicioCuidador);
	void removeServicioCuidador(ServiciocuidadorPK idServicio);
	Serviciocuidador retrieveServicioCuidador(Serviciocuidador servicio);
	Serviciocuidador retrieveServicioCuidador(ServiciocuidadorPK servicioCuidadorPK);
	List<Serviciocuidador> retrieveServiciosCuidador(int idCuidador);
}
