package vod;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import vod.model.GamesMuseum;
import vod.service.GameMuseumService;

import java.util.List;

@Component
@Slf4j
public class VodComponent {
    private final GameMuseumService gameMuseumService;

    public VodComponent(GameMuseumService gameMuseumService) {
        this.gameMuseumService = gameMuseumService;
    }
    @PostConstruct
    void init(){
        List<GamesMuseum> gamesMuseums = gameMuseumService.getAllMuseums();
        log.info("{} museums found.", gamesMuseums.size());
        gamesMuseums.forEach(gamesMuseum -> log.info("{}", gamesMuseums));    }
}
