package petcare.dao.interfaces;

import java.util.List;

import petcare.entities.Mascotareservada;
import petcare.entities.MascotareservadaPK;

public interface MascotaReservadaInt {
	void addMascotaReservada(Mascotareservada mascotaR);
	void removeMascotaReservada(Mascotareservada mascotaR);
	void removeMascotaReservada(MascotareservadaPK idMascotaR);
	void removeMascotaReservada(List<MascotareservadaPK> idsMascotasR);
	Mascotareservada retrieveMascota(Mascotareservada mascotaR);
	Mascotareservada retrieveMascota(MascotareservadaPK mascotaR);
	
}
