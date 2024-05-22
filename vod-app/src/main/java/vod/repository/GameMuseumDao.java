package vod.repository;

import vod.model.GamesMuseum;
import vod.model.Game;

import java.util.List;

public interface GameMuseumDao {

    List<GamesMuseum> findAll();

    GamesMuseum findById(int id);

    List<GamesMuseum> findByGame(Game g);

    GamesMuseum save(GamesMuseum museum);
}
