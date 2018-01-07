package tic.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tic.model.Step;

@Repository
public interface StepRepository extends CrudRepository<Step, Long> {
}
