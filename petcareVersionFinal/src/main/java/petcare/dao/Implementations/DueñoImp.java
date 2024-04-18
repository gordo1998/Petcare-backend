package petcare.dao.Implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import petcare.dao.interfaces.DueñoInt;
import petcare.dao.reposirtoryJpa.DueñoJpa;
import petcare.entities.Dueño;
public class DueñoImp implements DueñoInt {

	@Autowired
	DueñoJpa jpa;
	
	@Override
	public void addDueño(Dueño dueño) {
		jpa.save(dueño);
	}

	@Override
	public void removeDueño(Dueño dueño) {
		jpa.delete(dueño);
	}
	
	@Override
	public void removeDueño(int idDueño) {
		jpa.deleteById(idDueño);
	}
	
	@Override
	public Dueño retrieveDueño(Dueño dueño) {
		return jpa.getReferenceById(dueño.getIdDueño());
	}

	@Override
	public Dueño retrieveDueño(int idDueño) {
		return jpa.getReferenceById(idDueño);
	}

}
