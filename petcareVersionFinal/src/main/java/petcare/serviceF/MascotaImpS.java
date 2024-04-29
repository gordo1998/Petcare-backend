package petcare.serviceF;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import petcare.daoF.MascotaImp;
import petcare.daoF.MascotaInt;
import petcare.entities.Mascota;
@Service
public class MascotaImpS implements MascotaIntS{

	private MascotaImp dao = new MascotaImp();
	
	@Override
	public void addMascota(Mascota mascota) {
		dao.addMascota(mascota);
	}

	@Override
	public void removeMascota(Mascota mascota) {
		dao.removeMascota(mascota);
	}

	@Override
	public void removeMascota(int idMascota) {
		dao.removeMascota(idMascota);
	}

	@Override
	public void removeMascotas(List<Integer> mascotas) {
		for(Integer m: mascotas) {
			dao.removeMascota(m);
		}
	}

	@Override
	public Mascota retrieveMascota(Mascota mascota) {
		if(dao.retrieveMascota(mascota.getIdMascota()) != null) {
			return dao.retrieveMascota(mascota);
		}
		return null;
	}

	@Override
	public Mascota retrieveMascota(int idMascota) {
		if(dao.retrieveMascota(idMascota) != null) {
			return dao.retrieveMascota(idMascota);
		}
		return null;
	}

	@Override
	public List<Mascota> retrieveMascotas(int idDueño) {
		return dao.retrieveMascotas(idDueño);
	}

}
