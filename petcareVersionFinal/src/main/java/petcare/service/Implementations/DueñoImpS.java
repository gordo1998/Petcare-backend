package petcare.service.Implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import petcare.dao.Implementations.DueñoImp;
import petcare.dao.interfaces.DueñoInt;
import petcare.entities.Dueño;
import petcare.service.Interfaces.DueñoIntS;
@Service
public class DueñoImpS implements DueñoIntS{
	
	private DueñoImp dao = new DueñoImp();
	
	
	@Override
	public void addDueño(Dueño dueño) {
		dao.addDueño(dueño);
	}

	@Override
	public void removerDueño(Dueño dueño) {
		dao.removeDueño(dueño);
	}

	@Override
	public Dueño retrieveDueño(Dueño dueño) {
		if(dao.retrieveDueño(dueño.getIdDueño()) != null) {
			return dao.retrieveDueño(dueño);
		}
		return null;
	}

	@Override
	public Dueño retrieveDueño(int idDueño) {
		if(dao.retrieveDueño(idDueño) != null) {
			return dao.retrieveDueño(idDueño);
		}
		return null;
	}

}
