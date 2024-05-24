package vod.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import vod.model.GamesMuseum;
import vod.model.Game;
import vod.repository.GameMuseumDao;
import vod.repository.GameDao;
import vod.service.GameMuseumService;

import java.util.List;
import java.util.logging.Logger;
@Component
@Scope("prototype")
public class GameMuseumServiceBean implements GameMuseumService {

    private static final Logger log = Logger.getLogger(GameMuseumService.class.getName());

    private GameMuseumDao gameMuseumDao;
    private GameDao gameDao;

    public GameMuseumServiceBean(GameMuseumDao gameMuseumDao, GameDao gameDao) {
        log.info("creating Museum service bean");
        this.gameMuseumDao = gameMuseumDao;
        this.gameDao = gameDao;
    }

    @Override
    public GamesMuseum getMuseumsById(int id) {
        log.info("searching Museum by id " + id);
        return gameMuseumDao.findById(id);
    }

    @Override
    public List<Game> getGamesInMuseum(GamesMuseum c) {
        log.info("searching games available in Museum " + c.getId());
        return gameDao.findByMuseum(c);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @Override
    public GamesMuseum addMuseum(GamesMuseum m) {
        return gameMuseumDao.save(m);
    }

    @Override
    public List<GamesMuseum> getAllMuseums() {
        log.info("searching all Museums");
        return gameMuseumDao.findAll();
    }

    @Override
    public List<GamesMuseum> getMuseumByGame(Game m) {
        log.info("searching Museum by game " + m.getId());
        return gameMuseumDao.findByGame(m);
    }

}
