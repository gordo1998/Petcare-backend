package petcare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import petcare.dao.GetCuidadoresDao;
import petcare.entities.Sacarcuidadore;

@Service
public class GetCuidadoresServiceImp implements GetCuidadoresService {
	
	@Autowired
	GetCuidadoresDao cuidDao;
	
	@Override
	public List<Sacarcuidadore> getCuidadores() {
		// TODO Auto-generated method stub
		return cuidDao.getCuidadores();
	}

}
