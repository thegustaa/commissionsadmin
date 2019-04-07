package ar.edu.university.commissionsadmin.core.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.university.commissionsadmin.core.entities.Commission;
import ar.edu.university.commissionsadmin.core.repositories.CommissionsRepository;

@Service
public class CommissionsService {
	@Autowired
	CommissionsRepository commissionsRepository;
	
	public Optional<Commission> findById(Integer id){
		return commissionsRepository.findById(id);
	}

	public Iterable<Commission> findAll() {
		return commissionsRepository.findAll();
	}
}
