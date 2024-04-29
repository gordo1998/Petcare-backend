package petcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import petcare.serviceF.AnimalIntS;
@RestController
public class AnimalCtr {
	@Autowired
	AnimalIntS animal;
	
}
