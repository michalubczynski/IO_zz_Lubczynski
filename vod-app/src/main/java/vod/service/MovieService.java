package vod.service;

import vod.model.Producent;
import vod.model.Game;

import java.util.List;

public interface MovieService {


    List<Game> getAllGames();

    List<Game> getGamesByProducent(Producent p);

    Game getGameById(int id);

    Game addGame(Game g);


    List<Producent> getAllProducents();

    Producent getProducentById(int id);

    Producent addProducent(Producent p);
}
