package petcare.dao;

import java.util.List;

import petcare.entities.Cuenta;

public interface Crud<T> {
	//Añadir cuenta
	void addEntidad(T entidad);
	//Eliminar cuenta
	void removeEntidad(T entidad);
	//Eliminar cuenta por id
	void removeEntidad(int idEntidad);
	//Sacar toda la información
	List<T> getEntidad();
	//Busca información siguiendo unos parámetros
	T retrieveEntidades(int idEntidad); 
	T retrieveEntidades(T entidad);
	T retrieveEntidades(String correo, String contraseña); // esto será algo específico de la cuenta
	T retrieveEntidades(String correo); // esto también
	//Actualizar información
	void updateCuenta(T entidad);
}
