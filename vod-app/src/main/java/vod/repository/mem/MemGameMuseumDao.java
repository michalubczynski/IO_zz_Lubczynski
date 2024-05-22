package vod.repository.mem;

import vod.repository.GameMuseumDao;
import vod.model.GamesMuseum;
import vod.model.Game;

import java.util.List;
import java.util.stream.Collectors;


public class MemGameMuseumDao implements GameMuseumDao {

    @Override
    public List<GamesMuseum> findAll() {
        return SampleData.gamesMuseums;
    }

    @Override
    public GamesMuseum findById(int id) {
        return SampleData.gamesMuseums.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<GamesMuseum> findByGame(Game m) {
        return SampleData.gamesMuseums.stream().filter(c -> c.getGames().contains(m)).collect(Collectors.toList());
    }
}
