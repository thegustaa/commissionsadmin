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
		
	public Optional<Commissionstudent> findById(Integer id){
		return commissionsStudentRepository.findById(id);
	}

	public Iterable<Commissionstudent> findByStudentId(Integer idStudent) {
		return commissionsStudentRepository.findByStudentId(idStudent);
	}

	public Optional<Commissionstudent> findByCommissionIdAndStudentId(Integer idCommission, Integer idStudent) {
		return commissionsStudentRepository.findByCommissionIdAndStudentId(idCommission, idStudent);
	}

	public void save(Commissionstudent cs) {
		commissionsStudentRepository.save(cs);
	}

	public Iterable<Commissionstudent> findByCommissionId(Integer idCommission) {
		return commissionsStudentRepository.findByCommissionId(idCommission);
	}
}
