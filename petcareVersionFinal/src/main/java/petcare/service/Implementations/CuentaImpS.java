package petcare.service.Implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import petcare.dao.Implementations.CuentaImp;
import petcare.dao.interfaces.CuentaInt;
import petcare.entities.Cuenta;
import petcare.service.Interfaces.CuentaIntS;
@Service
public class CuentaImpS implements CuentaIntS{

	@Autowired
	CuentaInt dao;
	
	@Override
	public boolean addCuenta(Cuenta cuenta) {
		if (dao.retriveCuentas(cuenta.getIdCuenta()) == null) {
			dao.addCuenta(cuenta);
			return true;
		}
		return false;
	}

	@Override
	public void removeCuenta(Cuenta cuenta) {
		dao.removeCuenta(cuenta);
	}

	@Override
	public void removeCuenta(int idCuenta) {
		dao.removeCuenta(idCuenta);;
	}

	@Override
	public List<Cuenta> getCuentas() {
		return dao.getCuentas();
	}

	@Override
	public Cuenta retriveCuentas(int idCuenta) {
		if (dao.retriveCuentas(idCuenta) != null) {
			return dao.retriveCuentas(idCuenta);
		}
		return null;
	}

	@Override
	public Cuenta retriveCuentas(Cuenta cuenta) {
		if(dao.retriveCuentas(cuenta.getIdCuenta()) != null) {
			return dao.retriveCuentas(cuenta);
		}
		return null;
	}

	@Override
	public Cuenta retriveCuentas(String correo, String contraseña) {
		if(dao.retriveCuentas(correo, contraseña) != null) {
			return dao.retriveCuentas(correo, contraseña);
		}
		return null;
	}

	@Override
	public Cuenta retriveCuentas(String correo) {
		if(dao.retriveCuentas(correo) != null) {
			return dao.retriveCuentas(correo);
		}
		return null;
	}

}
