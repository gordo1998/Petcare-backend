package petcare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import petcare.dao.ServiceDao;
import petcare.entities.Servicio;
@Service
public class ServiceServiceImp implements ServiceService{
	@Autowired
	ServiceDao dao;

	@Override
	public List<Servicio> getServicios() {
		return dao.getServicio();
	}
	
}
