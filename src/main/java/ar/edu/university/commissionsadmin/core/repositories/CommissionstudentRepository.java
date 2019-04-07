package ar.edu.university.commissionsadmin.core.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ar.edu.university.commissionsadmin.core.entities.Commissionstudent;;

public interface CommissionstudentRepository extends CrudRepository<Commissionstudent, Integer> {

	Iterable<Commissionstudent> findByStudentId(Integer idStudent);

	Optional<Commissionstudent> findByCommissionIdAndStudentId(Integer idCommission, Integer idStudent);

	Iterable<Commissionstudent> findByCommissionId(Integer idCommission);
}
