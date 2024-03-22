package petcare.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;
import petcare.entities.Cuenta;
import petcare.entities.Reserva;
import petcare.entities.Serviciocuidador;

public interface CrudJpaRepository<T, ID> extends JpaRepository <T, ID>, Crud<T>{
	@Transactional
	@Modifying
	@Query("Delete from Cuenta i where i.idCuenta=?1")
	void removeByName(int id);
	
	@Query("Select i from Cuenta i where i.email = ?1 and i.passwd = ?2")
	Cuenta retrieveCuenta(String correo, String contraseña);
	
	@Query("Select i from Cuenta i where i.email = ?1")
	Cuenta retrieveCuenta(String correo);
	
	@Query("Select c from Cuenta c inner join Cuidador cd on c.idCuenta = cd.cuenta.idCuenta")
	List<Object> pruebilla();
	
	@Query("Select r from Reserva r where r.dueño.idDueño = ?1")
	List<Reserva> retrieveReservas(int idDueño);
	
	@Query("Select s from Serviciocuidador s where s.servicio.idServicio = ?1")
	List<Serviciocuidador> getServicioCuidador(int servicio);
	
	
}
