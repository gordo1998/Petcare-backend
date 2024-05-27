package petcare.daoF;

import petcare.entities.Dueño;

public interface DueñoInt {
	void addDueño(Dueño dueño);
	void removeDueño(Dueño dueño);
	void removeDueño(int idDueño);
	Dueño retrieveDueño(Dueño dueño);
	Dueño retrieveDueño(int idDueño);
	
}
