package petcare.dao.reposirtoryJpa;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import petcare.entities.*;
@Component
public interface CuentaJpa extends JpaRepository<Cuenta, Integer> {
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
	
}
