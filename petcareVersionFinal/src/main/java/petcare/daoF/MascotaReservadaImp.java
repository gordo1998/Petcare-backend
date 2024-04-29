package petcare.daoF;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import petcare.entities.Mascotareservada;
import petcare.entities.MascotareservadaPK;
public class MascotaReservadaImp implements MascotaReservadaInt {
	
	@Autowired
	MascotaReservadaJpa jpa;

	@Override
	public void addMascotaReservada(Mascotareservada mascotaR) {
		jpa.save(mascotaR);
	}

	@Override
	public void removeMascotaReservada(Mascotareservada mascotaR) {
		jpa.delete(mascotaR);
	}

	@Override
	public void removeMascotaReservada(MascotareservadaPK idMascotaR) {
		jpa.deleteById(idMascotaR);
	}

	@Override
	public void removeMascotaReservada(List<MascotareservadaPK> idsMascotasR) {
		for (MascotareservadaPK mr: idsMascotasR) {
			jpa.deleteById(mr);
		}
	}

	@Override
	public Mascotareservada retrieveMascota(Mascotareservada mascotaR) {
		return jpa.findById(mascotaR.getId()).orElse(null);
	}

	@Override
	public Mascotareservada retrieveMascota(MascotareservadaPK mascotaR) {
		return jpa.findById(mascotaR).orElse(null);
	}

}
