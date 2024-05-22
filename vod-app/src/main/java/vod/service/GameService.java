package vod.service;

import org.springframework.stereotype.Component;
import vod.model.Producent;
import vod.model.Game;

import java.util.List;
@Component
public interface GameService {


    List<Game> getAllGames();

    List<Game> getGamesByProducent(Producent p);

    Game getGameById(int id);

    Game addGame(Game g);


    List<Producent> getAllProducents();

    Producent getProducentById(int id);

    Producent addProducent(Producent p);
}
