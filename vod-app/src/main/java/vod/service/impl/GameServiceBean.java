package vod.service.impl;

import org.springframework.stereotype.Component;
import vod.repository.GameMuseumDao;
import vod.repository.ProducentDao;
import vod.repository.GameDao;
import vod.model.GamesMuseum;
import vod.model.Producent;
import vod.model.Game;
import vod.service.GameService;

import java.util.List;
import java.util.logging.Logger;
@Component
public class GameServiceBean implements GameService {

    private static final Logger log = Logger.getLogger(GameService.class.getName());

    private ProducentDao producentDao;
    private GameMuseumDao gameMuseumDao;
    private GameDao gameDao;

    public GameServiceBean(ProducentDao producentDao, GameMuseumDao gameMuseumDao, GameDao gameDao) {
        this.producentDao = producentDao;
        this.gameMuseumDao = gameMuseumDao;
        this.gameDao = gameDao;
    }

    public List<Game> getAllGames() {
        log.info("searching all games...");
        return gameDao.findAll();
    }

    public List<Game> getGamesByProducent(Producent d) {
        log.info("serching games by producent " + d.getId());
        return gameDao.findByProducent(d);
    }

    public List<Game> getMoviesInCinema(GamesMuseum gM) {
        log.info("searching games played in Museum " + gM.getId());
        return gameDao.findByMuseum(gM);
    }

    public Game getGameById(int id) {
        log.info("searching game by id " + id);
        return gameDao.findById(id);
    }

    public List<GamesMuseum> getAllMuseums() {
        log.info("searching all museums");
        return gameMuseumDao.findAll();
    }

    public List<GamesMuseum> getMuseumsByGame(Game g) {
        log.info("searching museums by game " + g.getId());
        return gameMuseumDao.findByGame(g);
    }

    public GamesMuseum getCinemaById(int id) {
        log.info("searching museum by id " + id);
        return gameMuseumDao.findById(id);
    }

    public List<Producent> getAllProducents() {
        log.info("searching all producents");
        return producentDao.findAll();
    }

    public Producent getProducentById(int id) {
        log.info("searching producent by id " + id);
        return producentDao.findById(id);
    }

    @Override
    public Game addGame(Game g) {
        log.info("about to add game " + g);
        return gameDao.add(g);
    }

    @Override
    public Producent addProducent(Producent p) {
        log.info("about to add producent " + p);
        return producentDao.add(p);
    }

}
