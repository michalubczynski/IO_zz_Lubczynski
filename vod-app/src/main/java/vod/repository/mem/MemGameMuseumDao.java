package vod.repository.mem;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import vod.repository.GameMuseumDao;
import vod.model.GamesMuseum;
import vod.model.Game;

import java.util.List;
import java.util.stream.Collectors;

@Repository("gameMuseumDao")
//@Primary
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

    @Override
    public GamesMuseum save(GamesMuseum museum) {
        int maxId = SampleData.gamesMuseums.stream()
                .sorted((c1, c2) -> c2.getId()-c1.getId())
                .findFirst()
                .map(c->c.getId())
                .orElse(0);
        museum.setId(maxId+1);
        SampleData.gamesMuseums.add(museum);
        return museum;
    }

}
