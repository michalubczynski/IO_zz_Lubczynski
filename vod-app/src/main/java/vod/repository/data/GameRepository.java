package vod.repository.data;

import org.springframework.data.jpa.repository.JpaRepository;
import vod.model.Game;
import vod.model.GamesMuseum;
import vod.model.Producent;

import java.util.List;


public interface GameRepository extends JpaRepository<Game, Integer> {
    List<Game> findAllByProducent(Producent p);
    List<Game> findAllByGameMuseumsContaining (GamesMuseum gm);
}
