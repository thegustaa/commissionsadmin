package ar.edu.university.commissionsadmin.core.repositories;

import org.springframework.data.repository.CrudRepository;

import ar.edu.university.commissionsadmin.core.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
}