package vod.service;

import vod.model.GamesMuseum;
import vod.model.Game;

import java.util.List;

public interface GameMuseumService {
    GamesMuseum getMuseumsById(int id);

    List<GamesMuseum> getAllMuseums();

    List<GamesMuseum> getMuseumByGame(Game g);

    List<Game> getGamesInMuseum(GamesMuseum gM);

}
