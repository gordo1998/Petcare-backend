package petcare.serviceF;

import petcare.entities.Dueño;

public interface DueñoIntS {
	void addDueño(Dueño dueño);
	void removerDueño(Dueño dueño);
	Dueño retrieveDueño(Dueño dueño);
	Dueño retrieveDueño(int idDueño);
}
