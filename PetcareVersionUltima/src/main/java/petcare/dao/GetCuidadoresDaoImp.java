package petcare.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import petcare.entities.Sacarcuidadore;

@Repository
public class GetCuidadoresDaoImp implements GetCuidadoresDao{
	@Autowired
	getCuidadoresJPA repo;

	@Override
	public List<Sacarcuidadore> getCuidadores() {
		// TODO Auto-generated method stub
		return repo.findAll();	
	}

}
