package ar.edu.university.commissionsadmin.core.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.university.commissionsadmin.core.entities.Commissionstudent;
import ar.edu.university.commissionsadmin.core.repositories.CommissionstudentRepository;

@Service
public class CommissionsStudentService {
	@Autowired
	CommissionstudentRepository commissionsStudentRepository;
		
	public Optional<Commissionstudent> find(Integer id){
		return commissionsStudentRepository.findById(id);
	}
}
