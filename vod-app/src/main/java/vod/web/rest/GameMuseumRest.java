package vod.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vod.model.GamesMuseum;
import vod.service.GameMuseumService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class GameMuseumRest {
    private final GameMuseumService gameMuseumService;

    @GetMapping("/museums")
    List<GamesMuseum> getMuseums(){
        log.info("about to retrieve museums list");
        List<GamesMuseum> museums = gameMuseumService.getAllMuseums();
        log.info("{} found", museums.size());
        return museums;
    }
}
