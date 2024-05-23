package vod.repository.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import vod.model.Game;
import vod.model.GamesMuseum;
import vod.model.Producent;
import vod.repository.GameDao;

import java.util.List;

@Repository
public class JpaGameDao implements GameDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Game> findAll() {
        return entityManager.createQuery("select g from Game g").getResultList();
    }

    @Override
    public Game findById(int id) {
        return entityManager.find(Game.class, id);
    }

    @Override
    public List<Game> findByProducent(Producent p) {
        return entityManager.createQuery("select g from Game g  where  g.producent=:producent")
                .setParameter("producent", p)
                .getResultList();
    }

    @Override
    public List<Game> findByMuseum(GamesMuseum gM) {
        return entityManager.createQuery("select g from Game g inner join g.gameMuseums gamesmuseum where gamesmuseum=:gamesmuseum")
                .setParameter("gamesmuseum", gM)
                .getResultList();    }

    public Game add(Game g) {
        entityManager.persist(g);
        return g;
    }
}
