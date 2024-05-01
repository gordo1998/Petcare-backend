package petcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import petcare.daoF.MascotaJpa;

@RestController
public class MascotaCtr {
	@Autowired
	MascotaJpa jpa;
	
	
}
