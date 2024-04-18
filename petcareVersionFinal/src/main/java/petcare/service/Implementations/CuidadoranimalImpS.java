package petcare.service.Implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import petcare.dao.Implementations.CuidadoranimalImp;
import petcare.dao.interfaces.CuidadoranimalInt;
import petcare.entities.Cuidadoranimal;
import petcare.entities.CuidadoranimalPK;
import petcare.service.Interfaces.CuidadoranimalIntS;
@Service
public class CuidadoranimalImpS implements CuidadoranimalIntS{
	
	private CuidadoranimalImp dao = new CuidadoranimalImp();
	
	@Override
	public void addCuidadorAnimal(Cuidadoranimal cuidadorAnimal) {
		dao.addCuidadorAnimal(cuidadorAnimal);
	}

	@Override
	public void addCuidadorAnimales(List<Cuidadoranimal> cuidadorAnimales) {
		dao.addCuidadorAnimales(cuidadorAnimales);
	}

	@Override
	public void removeCuidadorAnimal(Cuidadoranimal cuidadorAnimal) {
		dao.removeCuidadorAnimal(cuidadorAnimal);
	}

	@Override
	public void removeCuidadorAnimales(List<Cuidadoranimal> cuidadorAnimales) {
		dao.removeCuidadorAnimales(cuidadorAnimales);
	}

	@Override
	public void removeCuidadorAnimal(int idAnimal, int idCuidador) {
		dao.removeCuidadorAnimal(idAnimal, idCuidador);
	}

	@Override
	public void removeCuidadorAnimal(CuidadoranimalPK cuidadorAnimalpk) {
		dao.removeCuidadorAnimal(cuidadorAnimalpk);
	}

	@Override
	public Cuidadoranimal retrieveCuidadorAnimal(CuidadoranimalPK cuidadorAnimalpk) {
		if (dao.retrieveCuidadorAnimal(cuidadorAnimalpk) != null) {
			return dao.retrieveCuidadorAnimal(cuidadorAnimalpk);
		}
		return null;
	}

	@Override
	public Cuidadoranimal retrieveCuidadorAnimal(int idAnimal, int idCuidador) {
		if(dao.retrieveCuidadorAnimal(idAnimal, idCuidador) != null) {
			return dao.retrieveCuidadorAnimal(idAnimal, idCuidador);
		}
		return null;
	}

}
