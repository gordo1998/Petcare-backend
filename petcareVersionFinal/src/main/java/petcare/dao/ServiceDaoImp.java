package petcare.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import petcare.entities.Servicio;
@Repository
public class ServiceDaoImp implements ServiceDao{
	
	@Autowired
	ServiceJPA servicio;
	
	@Override
	public List<Servicio> getServicio() {
		return servicio.findAll();
	}

}
