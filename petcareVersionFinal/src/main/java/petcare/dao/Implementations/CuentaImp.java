package petcare.dao.Implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import petcare.dao.interfaces.CuentaInt;
import petcare.dao.reposirtoryJpa.CuentaJpa;
import petcare.entities.Cuenta;
@Component 
public class CuentaImp implements CuentaInt{

	@Autowired
	CuentaJpa CuentaJpa;
	
	@Override
	public void addCuenta(Cuenta cuenta) {
		CuentaJpa.save(cuenta);
		
	}

	@Override
	public void removeCuenta(Cuenta cuenta) {
		CuentaJpa.delete(cuenta);
	}

	@Override
	public List<Cuenta> getCuentas() {
		return CuentaJpa.findAll();
	}

	@Override
	public Cuenta retriveCuentas(int idCuenta) {
		return CuentaJpa.findById(idCuenta).orElse(null);
	}

	@Override
	public void updateCuenta(Cuenta cuenta) {
		// TODO Auto-generated method stub
		CuentaJpa.save(cuenta);
	}

	@Override
	public void removeCuenta(int idCuenta) {
		CuentaJpa.deleteById(idCuenta);
	}

	@Override
	public Cuenta retriveCuentas(Cuenta cuenta) {
		return CuentaJpa.findById(cuenta.getIdCuenta()).orElse(null);
	}

	@Override
	public Cuenta retriveCuentas(String correo, String contraseña) {
		return CuentaJpa.retrieveCuenta(correo, contraseña);
	}

	@Override
	public Cuenta retriveCuentas(String correo) {
		System.out.println("Esto es el CuentaJpa: " + CuentaJpa);
		return CuentaJpa.retrieveCuenta(correo);
	}
	
	public List<Object> pruebita(){
		return CuentaJpa.pruebilla();
	}
	
}
