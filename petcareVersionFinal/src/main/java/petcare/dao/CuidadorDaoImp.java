package petcare.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import petcare.entities.Cuidador;

public class CuidadorDaoImp implements CuidadorDao{
	@Autowired
	CuidadorJpa jpaCuidador;

	@Override
	public void addCuidador(Cuidador cuidador) {
		jpaCuidador.save(cuidador);
	}

	@Override
	public void removeCuidador(Cuidador cuidador) {
		jpaCuidador.delete(cuidador);
	}

	@Override
	public void removeCuidador(int primaryKey) {
		jpaCuidador.deleteById(primaryKey);
	}

	@Override
	public List<Cuidador> getCuidadores() {
		return jpaCuidador.findAll();
	}

	@Override
	public Cuidador retrieveCuidador(Cuidador cuidador) {
		return jpaCuidador.getReferenceById(cuidador.getIdCuidador());
	}

	@Override
	public Cuidador retrieveCuidador(int primaryKey) {
		return jpaCuidador.getReferenceById(primaryKey);
	}

	

}
