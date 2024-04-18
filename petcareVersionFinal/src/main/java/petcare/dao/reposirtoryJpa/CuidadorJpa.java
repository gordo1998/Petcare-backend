package petcare.dao.reposirtoryJpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import petcare.entities.*;
@Repository
public interface CuidadorJpa extends JpaRepository<Cuidador, Integer>{

}
