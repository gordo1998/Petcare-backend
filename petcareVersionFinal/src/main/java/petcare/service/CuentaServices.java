package petcare.service;

import java.util.List;

import petcare.entities.Cuenta;

public interface CuentaServices {
	boolean addCuenta(Cuenta cuenta);
	boolean deleteCuenta(Cuenta cuenta);
	boolean deleteCuenta(int idCuenta);
	List<Cuenta> retrieveCuentas();//Te permite devolver todas las cuentas
	Cuenta retrieveCuenta(int idCuenta);
	Cuenta retrieveCuenta(Cuenta cuenta);
	Cuenta retrieveCuenta(String correo, String contraseña);
	boolean updateCuenta(Cuenta cuenta);
	List<Object> getPrueba();
}
