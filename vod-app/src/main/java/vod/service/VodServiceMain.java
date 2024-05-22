package vod.service;

import vod.repository.GameMuseumDao;
import vod.repository.GameDao;
import vod.repository.mem.MemGameMuseumDao;
import vod.repository.mem.MemGameDao;
import vod.model.GamesMuseum;
import vod.service.impl.GameMuseumServiceBean;

import java.util.List;

public class VodServiceMain {

    public static void main(String[] args) {
        System.out.println("Let's find museums!");


        GameMuseumDao gameMuseumDao = new MemGameMuseumDao();
        GameDao gameDao = new MemGameDao();

        GameMuseumService service = new GameMuseumServiceBean(gameMuseumDao, gameDao);


        List<GamesMuseum> gamesMuseums = service.getAllMuseums();
        System.out.println(gamesMuseums.size() + " museums found:");
        gamesMuseums.forEach(System.out::println);
    }
}
