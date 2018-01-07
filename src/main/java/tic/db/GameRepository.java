package tic.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tic.model.Game;

@Repository
public interface GameRepository extends CrudRepository<Game, Long> {

}
