package vod.service;

import org.springframework.stereotype.Component;
import vod.model.GamesMuseum;
import vod.model.Game;

import java.util.List;

@Component
public interface GameMuseumService {
    GamesMuseum getMuseumsById(int id);

    List<GamesMuseum> getAllMuseums();

    List<GamesMuseum> getMuseumByGame(Game g);

    List<Game> getGamesInMuseum(GamesMuseum gM);

}
