package petcare.service.Implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import petcare.dao.Implementations.MascotaReservadaImp;
import petcare.dao.interfaces.MascotaReservadaInt;
import petcare.entities.Mascotareservada;
import petcare.entities.MascotareservadaPK;
import petcare.service.Interfaces.MascotaReservadaIntS;
@Service
public class MascotaReservadaImpS implements MascotaReservadaIntS{
	
	private MascotaReservadaImp dao = new MascotaReservadaImp();

	@Override
	public void addMascotaReservada(Mascotareservada mascotaR) {
		dao.addMascotaReservada(mascotaR);
	}

	@Override
	public void removeMascotaReservada(Mascotareservada mascotaR) {
		dao.removeMascotaReservada(mascotaR);
	}

	@Override
	public void removeMascotaReservada(MascotareservadaPK idMascotaR) {
		dao.removeMascotaReservada(idMascotaR);
	}

	@Override
	public void removeMascotaReservada(List<MascotareservadaPK> idsMascotasR) {
		for (MascotareservadaPK mr: idsMascotasR) {
			dao.removeMascotaReservada(mr);
		}
	}

	@Override
	public Mascotareservada retrieveMascota(Mascotareservada mascotaR) {
		if(dao.retrieveMascota(mascotaR.getId()) != null) {
			return dao.retrieveMascota(mascotaR);
		}
		return null;
	}

	@Override
	public Mascotareservada retrieveMascota(MascotareservadaPK mascotaR) {
		if(dao.retrieveMascota(mascotaR) != null) {
			return dao.retrieveMascota(mascotaR);
		}
		return null;
	}

}
