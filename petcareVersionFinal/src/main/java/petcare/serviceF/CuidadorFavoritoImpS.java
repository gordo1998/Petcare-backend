package petcare.serviceF;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import petcare.daoF.CuidadorFavoritoImp;
import petcare.daoF.CuidadorFavoritoInt;
import petcare.entities.Cuidadorfavorito;
import petcare.entities.CuidadorfavoritoPK;
@Service
public class CuidadorFavoritoImpS implements CuidadorFavoritoIntS{

	private CuidadorFavoritoImp dao = new CuidadorFavoritoImp();
	
	@Override
	public void addCuidadorFavorito(Cuidadorfavorito cuidadorFavorito) {
		dao.addCuidadorFavorito(cuidadorFavorito);
	}

	@Override
	public void removeCuidadorFavorito(Cuidadorfavorito cuidadorFavorito) {
		dao.removeCuidadorFavorito(cuidadorFavorito);
	}

	@Override
	public void removeCuidadorFavorito(CuidadorfavoritoPK cuidadorFavoritopk) {
		dao.removeCuidadorFavorito(cuidadorFavoritopk);
	}

	@Override
	public void removeCuidadoresFavoritos(List<CuidadorfavoritoPK> cuidadoresFavoritospk) {
		dao.removeCuidadoresFavoritos(cuidadoresFavoritospk);
	}

	@Override
	public Cuidadorfavorito retrieveCuidadorFavorito(Cuidadorfavorito cuidadorFavorito) {
		return dao.retrieveCuidadorFavorito(cuidadorFavorito);
	}

	@Override
	public Cuidadorfavorito retrieveCuidadorFavorito(CuidadorfavoritoPK cuidadorFavoritopk) {
		return dao.retrieveCuidadorFavorito(cuidadorFavoritopk);
	}

	@Override
	public List<Cuidadorfavorito> retrieveCuidadoresFavoritos(int idDueño) {
		return dao.retrieveCuidadoresFavoritos(idDueño);
	}

}
