package petcare.daoF;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import petcare.entities.Cuidadoranimal;
import petcare.entities.CuidadoranimalPK;

public class CuidadoranimalImp implements CuidadoranimalInt{
	@Autowired
	CuidadoranimalJpa jpa;

	@Override
	public void addCuidadorAnimal(Cuidadoranimal cuidadorAnimal) {
		jpa.save(cuidadorAnimal);
	}

	@Override
	public void addCuidadorAnimales(List<Cuidadoranimal> cuidadorAnimales) {
		for (Cuidadoranimal ca: cuidadorAnimales) {
			jpa.save(ca);
		}
	}

	@Override
	public void removeCuidadorAnimal(Cuidadoranimal cuidadorAnimal) {
		jpa.delete(cuidadorAnimal);
	}

	@Override
	public void removeCuidadorAnimales(List<Cuidadoranimal> cuidadorAnimales) {
		for (Cuidadoranimal ca: cuidadorAnimales) {
			jpa.delete(ca);
		}
	}

	@Override
	public Cuidadoranimal retrieveCuidadorAnimal(CuidadoranimalPK cuidadorAnimal) {
		return jpa.findById(cuidadorAnimal).orElse(null);
	}

	@Override
	public Cuidadoranimal retrieveCuidadorAnimal(int idAnimal, int idCuidador) {
		return jpa.retrieveCuidadorAnimal(idAnimal, idCuidador);
	}

	@Override
	public void removeCuidadorAnimal(int idAnimal, int idCuidador) {
		jpa.removeCuidadorAnimal(idAnimal, idCuidador);
	}

	@Override
	public void removeCuidadorAnimal(CuidadoranimalPK cuidadorAnimalpk) {
		jpa.deleteById(cuidadorAnimalpk);
	}

}
