package petcare.daoF;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import petcare.entities.Mascota;
public class MascotaImp implements MascotaInt {

	@Autowired
	MascotaJpa jpa;
	
	@Override
	public void addMascota(Mascota mascota) {
		jpa.save(mascota);	
	}

	@Override
	public void removeMascota(Mascota mascota) {
		jpa.delete(mascota);
	}

	@Override
	public void removeMascota(int idMascota) {
		jpa.deleteById(idMascota);
	}

	@Override
	public void removeMascotas(List<Integer> mascotas) {
		for (Integer m: mascotas) {
			jpa.deleteById(m);
		}
	}

	@Override
	public Mascota retrieveMascota(Mascota mascota) {
		return jpa.findById(mascota.getIdMascota()).orElse(null);
	}

	@Override
	public Mascota retrieveMascota(int idMascota) {
		// TODO Auto-generated method stub
		return jpa.findById(idMascota).orElse(null);
	}

	@Override
	public List<Mascota> retrieveMascotas(int idDueño) {
		return jpa.retrieveMascotas(idDueño);
	}

	
}
