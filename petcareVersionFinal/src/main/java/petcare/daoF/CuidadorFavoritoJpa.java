package petcare.daoF;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import petcare.entities.*;

@Repository
public interface CuidadorFavoritoJpa extends JpaRepository<Cuidadorfavorito, CuidadorfavoritoPK> {
		@Query("Select c from Cuidadorfavorito c where c.id.idDueñoDelFavorito = ?1")
		List<Cuidadorfavorito> retrieveCuidadoresFavorito(int idDueño);
}
