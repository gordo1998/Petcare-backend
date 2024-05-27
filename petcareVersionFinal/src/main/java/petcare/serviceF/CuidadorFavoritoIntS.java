package petcare.serviceF;

import java.util.List;

import petcare.entities.Cuidadorfavorito;
import petcare.entities.CuidadorfavoritoPK;

public interface CuidadorFavoritoIntS {
	void addCuidadorFavorito(Cuidadorfavorito cuidadorFavorito);
	void removeCuidadorFavorito(Cuidadorfavorito cuidadorFavorito);
	void removeCuidadorFavorito(CuidadorfavoritoPK cuidadorFavoritopk);
	void removeCuidadoresFavoritos(List<CuidadorfavoritoPK> cuidadoresFavoritospk);
	Cuidadorfavorito retrieveCuidadorFavorito(Cuidadorfavorito cuidadorFavorito);
	Cuidadorfavorito retrieveCuidadorFavorito(CuidadorfavoritoPK cuidadorFavoritopk);
	List<Cuidadorfavorito> retrieveCuidadoresFavoritos(int idDueño);
}
