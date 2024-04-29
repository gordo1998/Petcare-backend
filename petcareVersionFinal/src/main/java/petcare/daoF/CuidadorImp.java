package petcare.daoF;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import petcare.daoF.CuidadorJpa;
import petcare.entities.Cuidador;
@Repository
public class CuidadorImp implements CuidadorInt{

	@Autowired
	CuidadorJpa j;
	
	@Override
	public void addCuidador(Cuidador cuidador) {
		j.save(cuidador);
	}

	@Override
	public void removeCuidador(Cuidador cuidador) {
		j.delete(cuidador);
	}

	@Override
	public void removeCuidador(int idCuidador) {
		j.deleteById(idCuidador);
	}

	@Override
	public Cuidador retrieveCuidador(Cuidador cuidador) {
		return j.getReferenceById(cuidador.getIdCuidador());
	}

	@Override
	public Cuidador retrieveCuidador(int idCuidador) {
		return j.getReferenceById(idCuidador);
	}

	@Override
	public List<Cuidador> retrieveCuidadores() {
		return j.findAll();
	}
	
	@Override
	public void updateAccesFirst(int acces, int idCuidador) {
		j.updateAccessFirst(acces, idCuidador);
	}
	
	@Override
	public int retrieveAccess(int idCuidador) {
		return j.retrieveAccess(idCuidador);
	}
	
	

}
