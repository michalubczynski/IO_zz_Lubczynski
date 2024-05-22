package vod.repository.dummy;

import org.springframework.stereotype.Component;
import vod.model.Game;
import vod.model.GamesMuseum;
import vod.repository.GameMuseumDao;

import java.util.List;
@Component
public class DummyGameMuseumDao implements GameMuseumDao {
    @Override
    public List<GamesMuseum> findAll() {
        return List.of();
    }

    @Override
    public GamesMuseum findById(int id) {
        return null;
    }

    @Override
    public List<GamesMuseum> findByGame(Game g) {
        return List.of();
    }
}
