package vod.repository.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import vod.model.Game;
import vod.model.GamesMuseum;
import vod.repository.GameMuseumDao;

import java.util.List;

@Repository
public class JpaGamesMuseumDao implements GameMuseumDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<GamesMuseum> findAll() {
        return entityManager.createQuery("select gM from GamesMuseum gM").getResultList();
    }

    @Override
    public GamesMuseum findById(int id) {
        return entityManager.find(GamesMuseum.class, id);
    }

    @Override
    public List<GamesMuseum> findByGame(Game g) {
        return entityManager.createQuery("select gM from GamesMuseum gM join gM.games game where game = :game", GamesMuseum.class)
                .setParameter("game", g)
                .getResultList();
    }

    @Override
    public GamesMuseum save(GamesMuseum museum) {
        entityManager.persist(museum);
        return museum;
    }
}
