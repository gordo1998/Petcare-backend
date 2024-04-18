package petcare.dao.Implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import petcare.dao.interfaces.CuidadorInt;
import petcare.dao.reposirtoryJpa.*;
import petcare.entities.Cuidador;

public class CuidadorImp implements CuidadorInt{

	@Autowired
	CuidadorJpa jpa;
	
	@Override
	public void addCuidador(Cuidador cuidador) {
		jpa.save(cuidador);
	}

	@Override
	public void removeCuidador(Cuidador cuidador) {
		jpa.delete(cuidador);
	}

	@Override
	public void removeCuidador(int idCuidador) {
		jpa.deleteById(idCuidador);
	}

	@Override
	public Cuidador retrieveCuidador(Cuidador cuidador) {
		return jpa.getReferenceById(cuidador.getIdCuidador());
	}

	@Override
	public Cuidador retrieveCuidador(int idCuidador) {
		return jpa.getReferenceById(idCuidador);
	}

	@Override
	public List<Cuidador> retrieveCuidadores() {
		return jpa.findAll();
	}

}
