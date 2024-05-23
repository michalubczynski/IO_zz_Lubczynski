package vod.repository.data;

import org.springframework.data.jpa.repository.JpaRepository;
import vod.model.Game;


public interface GameRepository extends JpaRepository<Game, Integer> {
}
