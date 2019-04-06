package ar.edu.university.commissionsadmin.rest.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ar.edu.university.commissionsadmin.core.entities.Commissionstudent;
import ar.edu.university.commissionsadmin.core.exceptions.ResourceNotFoundException;
import ar.edu.university.commissionsadmin.core.services.CommissionsStudentService;

@RestController
@RequestMapping("api/v1/commissionsstudents")
public class CommissionstudentController {

	@Autowired 
	CommissionsStudentService commissionsStudentService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Commissionstudent get(@PathVariable Integer id) {		
		Optional<Commissionstudent> cs= commissionsStudentService.find(id);
		
		if (!cs.isPresent()) {
	            throw new ResourceNotFoundException("Resource not found.");
	
		}
        return cs.get();
	}
	
}
