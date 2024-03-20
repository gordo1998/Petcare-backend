package petcare.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import petcare.entities.Cuenta;

@Service
public interface CuentasDao {
	//Añadir cuenta
		void addCuenta(Cuenta cuenta);
		//Eliminar cuenta
		void removeCuenta(Cuenta cuenta);
		//Eliminar cuenta por id
		void removeCuenta(int idCuenta);
		//Sacar toda la información
		List<Cuenta> getCuenta();
		//Eliminar información desde un índice
		Cuenta retriveCuentas(int idCuenta);
		Cuenta retriveCuentas(Cuenta cuenta);
		Cuenta retriveCuentas(String correo, String contraseña);
		Cuenta retriveCuentas(String correo);
		//Actualizar información
		void updateCuenta(Cuenta cuenta);
		List<Object> pruebita();
}
