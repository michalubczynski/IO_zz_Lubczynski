package vod.repository.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vod.model.Game;
import vod.model.GamesMuseum;

import java.util.List;

public interface GamesMuseumRepository extends JpaRepository<GamesMuseum, Integer> {

    List<GamesMuseum> findAllByNameContaining(String name);
    @Query("select gm from GamesMuseum gm inner join gm.games game where game=:game")
    List<GamesMuseum> findAllByGame(@Param("game")Game game);
}
