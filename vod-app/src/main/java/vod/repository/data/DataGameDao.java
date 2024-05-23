package vod.repository.data;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import vod.model.Game;
import vod.model.GamesMuseum;
import vod.model.Producent;
import vod.repository.GameDao;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Primary
public class DataGameDao implements GameDao {

    private final GameRepository repository;


    @Override
    public List<Game> findAll() { return repository.findAll(); }

    @Override
    public Game findById(int id) { return repository.findById(id).orElse(null); }

    @Override
    public List<Game> findByProducent(Producent p) { return repository.findAllByProducent(p); }
    @Override
    public List<Game> findByMuseum(GamesMuseum gm) { return repository.findAllByGameMuseumsContaining(gm); }

    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public Game add(Game g) { return repository.save(g); }

}
