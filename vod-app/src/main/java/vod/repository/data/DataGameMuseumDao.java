package vod.repository.data;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import vod.model.Game;
import vod.model.GamesMuseum;
import vod.repository.GameMuseumDao;

import java.util.List;

@Repository
@Primary
@RequiredArgsConstructor
public class DataGameMuseumDao implements GameMuseumDao {

    private final GamesMuseumRepository repository;

    @Override
    public List<GamesMuseum> findAll() {
        return repository.findAll();
    }

    @Override
    public GamesMuseum findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<GamesMuseum> findByGame(Game g) {
        return repository.findAllByGame(g);
    }

    @Override
    public GamesMuseum save(GamesMuseum museum) {
        return repository.save(museum);
    }
}
