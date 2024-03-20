package petcare.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import petcare.entities.Cuenta;
@Repository
public class CuentasDaoImpl implements CuentasDao{
	@Autowired
	CuentasJpaRepository cuentaJpa;

	@Override
	public void addCuenta(Cuenta cuenta) {
		// TODO Auto-generated method stub
		cuentaJpa.save(cuenta);
		
	}

	@Override
	public void removeCuenta(Cuenta cuenta) {
		// TODO Auto-generated method stub
		cuentaJpa.delete(cuenta);
	}

	@Override
	public List<Cuenta> getCuenta() {
		// TODO Auto-generated method stub
		return cuentaJpa.findAll();
	}

	@Override
	public Cuenta retriveCuentas(int idCuenta) {
		// TODO Auto-generated method stub
		return cuentaJpa.findById(idCuenta).orElse(null);
	}

	@Override
	public void updateCuenta(Cuenta cuenta) {
		// TODO Auto-generated method stub
		cuentaJpa.save(cuenta);
	}

	@Override
	public void removeCuenta(int idCuenta) {
		// TODO Auto-generated method stub
		cuentaJpa.deleteById(idCuenta);
	}

	@Override
	public Cuenta retriveCuentas(Cuenta cuenta) {
		// TODO Auto-generated method stub
		return cuentaJpa.findById(cuenta.getIdCuenta()).orElse(null);
	}

	@Override
	public Cuenta retriveCuentas(String correo, String contraseña) {
		// TODO Auto-generated method stub
		return cuentaJpa.retrieveCuenta(correo, contraseña);
	}

	@Override
	public Cuenta retriveCuentas(String correo) {
		// TODO Auto-generated method stub
		return cuentaJpa.retrieveCuenta(correo);
	}
	
	public List<Object> pruebita(){
		return cuentaJpa.pruebilla();
	}
	
}
