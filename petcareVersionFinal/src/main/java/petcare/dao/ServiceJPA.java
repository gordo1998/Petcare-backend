package petcare.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import petcare.entities.Servicio;
@Service
public interface ServiceJPA extends JpaRepository<Servicio, Integer>{

}
