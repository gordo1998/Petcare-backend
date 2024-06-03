package petcare.daoF;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import petcare.entities.*;

@Repository
public interface MascotaReservadaJpa extends JpaRepository<Mascotareservada, MascotareservadaPK>{

	@Query("Select m.id.idMascotaR from Mascotareservada m join Reserva r on m.id.idReservaR = r.idReserva where r.dueño.idDueño = ?1")
	List<MascotareservadaPK> getMascotasReservadasByDueño(int idDuenyo);
}
