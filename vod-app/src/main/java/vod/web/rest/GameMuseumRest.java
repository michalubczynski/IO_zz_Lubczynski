package vod.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vod.model.Game;
import vod.model.GamesMuseum;
import vod.service.GameMuseumService;
import vod.service.GameService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("webapi")
public class GameMuseumRest {

    private final GameMuseumService gameMuseumService;
    private final GameService gameService;

    @GetMapping("/museums")
    List<GamesMuseum> getMuseums(@RequestParam(value = "phrase", required = false)String phrase,
                                 @RequestHeader(value = "custom-header", required = false)String customHeader){
        log.info("about to retrieve museums list");
        List<GamesMuseum> museums = gameMuseumService.getAllMuseums();
        log.info("{} found", museums.size());
        return museums;
    }
    @GetMapping("/museums/{id}")
    ResponseEntity<GamesMuseum> getMuseum(@PathVariable("id") int id){
        log.info("about to retrieve cinema {}", id);
        GamesMuseum gamesMuseum = gameMuseumService.getMuseumsById(id);
        log.info("Found", gamesMuseum);
        if(gamesMuseum != null){
            return ResponseEntity.status(200).body(gamesMuseum);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/games/{gameId}/gamesMuseums")
    ResponseEntity<List<GamesMuseum>> getMuseumsWithGame(@PathVariable("gameId") int gameId){
        log.info("searching {}", gameId);
        Game game = gameService.getGameById(gameId);
        if(game == null){
            return ResponseEntity.notFound().build();
        }
        else {
            List<GamesMuseum> museums = gameMuseumService.getMuseumByGame(game);
            log.info("found {} museums with title {}", museums.size(), game.getTitle() );
            return ResponseEntity.ok(museums);
        }
    }
    @PostMapping("/museums")
    ResponseEntity<GamesMuseum> addMuseum(@RequestBody GamesMuseum museum){
        log.info("add new museum {}", museum);
        museum = gameMuseumService.addMuseum(museum);
        return ResponseEntity.status(HttpStatus.CREATED).body(museum);
    }
}
