package petcare.dao.interfaces;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import petcare.entities.Cuenta;
@Component
public interface CuentaInt {
	void addCuenta(Cuenta cuenta);
	//Eliminar cuenta
	void removeCuenta(Cuenta cuenta);
	//Eliminar cuenta por id
	void removeCuenta(int idCuenta);
	//Sacar toda la información
	List<Cuenta> getCuentas();
	//Eliminar información desde un índice
	Cuenta retriveCuentas(int idCuenta);
	Cuenta retriveCuentas(Cuenta cuenta);
	Cuenta retriveCuentas(String correo, String contraseña);
	Cuenta retriveCuentas(String correo);
	//Actualizar información
	void updateCuenta(Cuenta cuenta);
	List<Object> pruebita();
}
