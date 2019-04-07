package ar.edu.university.commissionsadmin.rest.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.university.commissionsadmin.core.entities.Commission;
import ar.edu.university.commissionsadmin.core.entities.Commissionstudent;
import ar.edu.university.commissionsadmin.core.entities.Student;
import ar.edu.university.commissionsadmin.core.services.CommissionsStudentService;
import ar.edu.university.commissionsadmin.core.services.StudentsService;

@RestController
@RequestMapping("api/v1/students")
public class StudentsController {
	@Autowired
	StudentsService studentsService;

	@Autowired
	CommissionsStudentService commissionStudentService;

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Student> getAll() {
		Iterable<Student> list = studentsService.findAll();

		return list;
	}

	@RequestMapping(value = "{idStudent}/commissions", method = RequestMethod.GET)
	public Iterable<Commission> getCommissions(@PathVariable Integer idStudent) {
		Iterable<Commissionstudent> list = commissionStudentService.findByStudentId(idStudent);
		List<Commission> commissions = new ArrayList<Commission>();
		for (Commissionstudent commissionstudent : list) {
			commissions.add(commissionstudent.getCommission());
		}
		return commissions;
	}

	@RequestMapping(value = "{idStudent}/commissionsstudent/{idCommission}", 
			method = RequestMethod.GET)
	public Commissionstudent getStudentCommissions(@PathVariable Integer idStudent,
			@PathVariable Integer idCommission) {
		Optional<Commissionstudent> commissionstudent = commissionStudentService
				.findByCommissionIdAndStudentId(idCommission, idStudent);

		return commissionstudent.get();
	}

}