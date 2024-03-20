package petcare.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import petcare.entities.Cuidador;

public interface CuidadorJpa extends JpaRepository<Cuidador, Integer>{
	//TODO Mirar esta clase aunque no creo que sea necesario hacer nada
}
