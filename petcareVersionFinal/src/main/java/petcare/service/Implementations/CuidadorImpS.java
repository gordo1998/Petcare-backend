package petcare.service.Implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import petcare.dao.Implementations.CuidadorImp;
import petcare.dao.interfaces.CuidadorInt;
import petcare.entities.Cuidador;
import petcare.service.Interfaces.CuidadorIntS;
@Service
public class CuidadorImpS implements CuidadorIntS{
	
	private CuidadorImp dao = new CuidadorImp();

	@Override
	public void addCuidador(Cuidador cuidador) {
		dao.addCuidador(cuidador);
	}

	@Override
	public void removeCuidador(Cuidador cuidador) {
		dao.removeCuidador(cuidador);
	}

	@Override
	public void removeCuidador(int idCuidador) {
		dao.removeCuidador(idCuidador);
	}

	@Override
	public Cuidador retrieveCuidador(Cuidador cuidador) {
		return dao.retrieveCuidador(cuidador);
	}

	@Override
	public Cuidador retrieveCuidador(int idCuidador) {
		return dao.retrieveCuidador(idCuidador);
	}

	@Override
	public List<Cuidador> retrieveCuidadores() {
		return dao.retrieveCuidadores();
	}

}
