package petcare.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import petcare.entities.Sacarcuidadore;
@Service
public interface getCuidadoresJPA extends JpaRepository<Sacarcuidadore, Integer>{
	
	
}
