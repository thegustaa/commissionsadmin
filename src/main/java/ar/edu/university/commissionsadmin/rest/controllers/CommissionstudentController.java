package ar.edu.university.commissionsadmin.rest.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.university.commissionsadmin.core.entities.Commissionstudent;
import ar.edu.university.commissionsadmin.core.exceptions.ForbiddenOperationException;
import ar.edu.university.commissionsadmin.core.exceptions.ResourceNotFoundException;
import ar.edu.university.commissionsadmin.core.services.CommissionsStudentService;
import ar.edu.university.commissionsadmin.rest.requests.EditStudentCommissionScoreRequest;

@RestController
@RequestMapping("api/v1/commissionsstudents")
public class CommissionstudentController {

	@Autowired 
	CommissionsStudentService commissionsStudentService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Commissionstudent get(@PathVariable Integer id) {		
		Optional<Commissionstudent> cs= commissionsStudentService.findById(id);
		
		if (!cs.isPresent()) {
	            throw new ResourceNotFoundException("Resource not found.");
	
		}
        return cs.get();
	}	
	
	@RequestMapping(value = "/{id}", 
			method = RequestMethod.PUT,
			consumes = {"application/json"},
	        produces = {"application/json"})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void saveFinalScore(@RequestBody EditStudentCommissionScoreRequest request, @PathVariable Integer id) {		
		Optional<Commissionstudent> optCs= commissionsStudentService.findById(id);
		
		if (!optCs.isPresent()) {
	            throw new ResourceNotFoundException("No se encontró estudiante.");	
		} else {
			Commissionstudent cs = optCs.get();
			if (cs.getStudentsituation().isRegularStudent()){
				cs.setFinalscore(request.getFinalscore());
				commissionsStudentService.save(cs);
			} else {
				throw new ForbiddenOperationException("No puede cargar nota en estudiante no regular.");
			}			
		}	
	}

	@RequestMapping(value="/search", 
			method= RequestMethod.GET,
	        produces = {"application/json"})
	public Iterable<Commissionstudent> search(
			@RequestParam(name="id_commission", required=false, defaultValue="-1") Integer idCommission) {
		Iterable<Commissionstudent> results = null;
		if (idCommission != -1) {
			results = commissionsStudentService.findByCommissionId(idCommission);
		}
		return results;	
	}
}
