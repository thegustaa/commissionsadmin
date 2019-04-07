package ar.edu.university.commissionsadmin.core.repositories;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import ar.edu.university.commissionsadmin.core.entities.Commission;

public interface CommissionsRepository extends CrudRepository<Commission, Integer>  {

	public Optional<Commission> findById(Integer id);

}
