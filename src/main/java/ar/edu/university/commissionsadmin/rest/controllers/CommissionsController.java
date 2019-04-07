package ar.edu.university.commissionsadmin.rest.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.university.commissionsadmin.core.entities.Commission;
import ar.edu.university.commissionsadmin.core.exceptions.ResourceNotFoundException;
import ar.edu.university.commissionsadmin.core.services.CommissionsService;

@RestController
@RequestMapping("api/v1/commissions")
public class CommissionsController {
	
	@Autowired
	CommissionsService commissionsService;
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Commission> getAll() {
		Iterable<Commission> list = commissionsService.findAll();
		return list;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Commission get(@PathVariable Integer id) {		
		Optional<Commission> commission= commissionsService.findById(id);
		
		if (!commission.isPresent()) {
	            throw new ResourceNotFoundException("Resource not found.");

		}
	    return commission.get();
	}	
}

