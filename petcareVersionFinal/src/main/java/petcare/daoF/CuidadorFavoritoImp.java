package petcare.daoF;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import petcare.entities.Cuidadorfavorito;
import petcare.entities.CuidadorfavoritoPK;
public class CuidadorFavoritoImp implements CuidadorFavoritoInt {
	
	@Autowired
	CuidadorFavoritoJpa jpa;

	@Override
	public void addCuidadorFavorito(Cuidadorfavorito cuidadorFavorito) {
		jpa.save(cuidadorFavorito);
	}

	@Override
	public void removeCuidadorFavorito(Cuidadorfavorito cuidadorFavorito) {
		jpa.delete(cuidadorFavorito);
	}

	@Override
	public void removeCuidadorFavorito(CuidadorfavoritoPK cuidadorFavoritopk) {
		jpa.deleteById(cuidadorFavoritopk);
	}
	
	@Override
	public void removeCuidadoresFavoritos(List<CuidadorfavoritoPK> cuidadoresFavoritospk) {
		for (CuidadorfavoritoPK cf: cuidadoresFavoritospk) {
			jpa.deleteById(cf);
		}
	}

	@Override
	public Cuidadorfavorito retrieveCuidadorFavorito(Cuidadorfavorito cuidadorFavorito) {
		return jpa.findById(cuidadorFavorito.getId()).orElse(null);
	}

	@Override
	public Cuidadorfavorito retrieveCuidadorFavorito(CuidadorfavoritoPK cuidadorFavoritopk) {
		return jpa.findById(cuidadorFavoritopk).orElse(null);
	}

	@Override
	public List<Cuidadorfavorito> retrieveCuidadoresFavoritos(int idDueño) {
		return jpa.retrieveCuidadoresFavorito(idDueño);
	}

	
}
