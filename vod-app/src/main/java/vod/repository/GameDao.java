package vod.repository;

import vod.model.GamesMuseum;
import vod.model.Producent;
import vod.model.Game;

import java.util.List;

public interface GameDao {

    List<Game> findAll();

    Game findById(int id);

    List<Game> findByProducent(Producent p);

    List<Game> findByMuseum(GamesMuseum gM);

    Game add(Game g);

}
