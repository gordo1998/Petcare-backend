package petcare.daoF;

import java.util.List;

import petcare.entities.Cuidadorfavorito;
import petcare.entities.CuidadorfavoritoPK;

public interface CuidadorFavoritoInt {
	void addCuidadorFavorito(Cuidadorfavorito cuidadorFavorito);
	//POSIBILIDAD DE AÑADIR ADDCUIDADORESFAVORITOS
	void removeCuidadorFavorito(Cuidadorfavorito cuidadorFavorito);
	void removeCuidadorFavorito(CuidadorfavoritoPK cuidadorFavoritopk);
	void removeCuidadoresFavoritos(List<CuidadorfavoritoPK> cuidadoresFavoritospk);
	Cuidadorfavorito retrieveCuidadorFavorito(Cuidadorfavorito cuidadorFavorito);
	Cuidadorfavorito retrieveCuidadorFavorito(CuidadorfavoritoPK cuidadorFavoritopk);
	List<Cuidadorfavorito> retrieveCuidadoresFavoritos(int idDueño);
}
