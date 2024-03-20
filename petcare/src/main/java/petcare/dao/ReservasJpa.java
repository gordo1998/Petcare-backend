package petcare.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import petcare.entities.Reserva;
@Service
public interface ReservasJpa extends JpaRepository<Reserva, Integer>{

}
