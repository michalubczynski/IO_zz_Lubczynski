package vod.repository.mem;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import vod.repository.GameDao;
import vod.model.GamesMuseum;
import vod.model.Producent;
import vod.model.Game;

import java.util.List;
import java.util.stream.Collectors;
@Repository("gameDao")
public class MemGameDao implements GameDao {
    @Override
    public List<Game> findAll() {
        return SampleData.games;
    }

    @Override
    public Game findById(int id) {
        return SampleData.games.stream().filter(m -> m.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Game> findByProducent(Producent d) {
       return SampleData.games.stream().filter(m -> m.getProducent() == d).collect(Collectors.toList());
    }

    @Override
    public List<Game> findByMuseum(GamesMuseum c) {
        return SampleData.games.stream().filter(m -> m.getMuseums().contains(c)).collect(Collectors.toList());
    }

    @Override
    public Game add(Game m) {
        int max = SampleData.games.stream().max((m1, m2) -> m1.getId() - m2.getId()).get().getId();
        m.setId(++max);
        SampleData.games.add(m);
        return m;
    }
}
