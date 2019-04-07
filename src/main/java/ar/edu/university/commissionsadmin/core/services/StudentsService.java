package ar.edu.university.commissionsadmin.core.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.university.commissionsadmin.core.entities.Student;
import ar.edu.university.commissionsadmin.core.repositories.StudentRepository;

@Service
public class StudentsService {
	@Autowired
	StudentRepository studentsRepository;
		
	public Iterable<Student> findAll(){
		return studentsRepository.findAll();
	}
}
