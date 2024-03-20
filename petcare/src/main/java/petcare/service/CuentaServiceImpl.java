package petcare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import petcare.dao.CuentasDao;
import petcare.entities.Cuenta;
@Service
public class CuentaServiceImpl implements CuentaServices {
	@Autowired
	CuentasDao cuentaDao;

	@Override
	public boolean addCuenta(Cuenta cuenta) {
		// TODO Auto-generated method stub
		if(cuentaDao.retriveCuentas(cuenta.getEmail()) == null) {
			cuentaDao.addCuenta(cuenta);
			return true;
		}
		return false;
	}
	
	

	@Override
	public boolean deleteCuenta(Cuenta cuenta) {
		// TODO Auto-generated method stub
		if(cuentaDao.retriveCuentas(cuenta.getIdCuenta()) != null) {
			cuentaDao.removeCuenta(cuenta);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteCuenta(int idCuenta) {
		// TODO Auto-generated method stub
		if(cuentaDao.retriveCuentas(idCuenta) != null) {
			cuentaDao.removeCuenta(idCuenta);
			return true;
		}
		return false;
	}

	@Override
	public List<Cuenta> retrieveCuentas() {
		// TODO Auto-generated method stub
		return cuentaDao.getCuenta();
	}

	@Override
	public boolean updateCuenta(Cuenta cuenta) {
		// TODO Auto-generated method stub
		if(cuentaDao.retriveCuentas(cuenta.getIdCuenta()) != null) {
			cuentaDao.addCuenta(cuenta);
			return true;
		}
		return false;
	}


	@Override
	public Cuenta retrieveCuenta(int idCuenta) {
		// TODO Auto-generated method stub
		return cuentaDao.retriveCuentas(idCuenta);
	}
	
	@Override
	public Cuenta retrieveCuenta(String correo, String contraseña) {
		return cuentaDao.retriveCuentas(correo, contraseña);
	}

	@Override
	public Cuenta retrieveCuenta(Cuenta cuenta) {
		return cuentaDao.retriveCuentas(cuenta);
	}



	@Override
	public List<Object> getPrueba() {
		// TODO Auto-generated method stub
		return cuentaDao.pruebita();
	}
	
}
