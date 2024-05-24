package museums.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import museums.model.Gamesmuseum;

import java.util.List;

public interface GameMuseumRepository extends JpaRepository<Gamesmuseum, Integer> {

    List<Gamesmuseum> findGamesmuseumsByGamesIsContaining(int id);
}
