package petcare.service.Interfaces;

import java.util.List;

import petcare.entities.Mascota;

public interface MascotaIntS {
	void addMascota(Mascota mascota);
	void removeMascota(Mascota mascota);
	void removeMascota(int idMascota);
	void removeMascotas(List<Integer> mascotas);
	Mascota retrieveMascota(Mascota mascota);
	Mascota retrieveMascota(int idMascota);
	List<Mascota> retrieveMascotas(int idDueño);
}
