package petcare.daoF;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import petcare.entities.*;
@Repository
public interface AnimalJpa extends JpaRepository<Animal, Integer>{

}
