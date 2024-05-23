package vod.web.rest;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import vod.model.Game;
import vod.model.GamesMuseum;
import vod.service.GameMuseumService;
import vod.service.GameService;
import vod.web.rest.dto.GameDTO;

import java.util.List;
import java.util.Locale;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class GameRest {

    private final GameMuseumService gameMuseumService;
    private final GameService gameService;
    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;


    @GetMapping("/games")
    List<Game> getGames(){
        List<Game> games = gameService.getAllGames();
        return games;
    }
    @GetMapping("/games/{id}")
    ResponseEntity<Game> getGame(@PathVariable("id") int id){
        log.info("about to retrieve cinema {}", id);
        Game game = gameService.getGameById(id);
        log.info("Found", game);
        if(game != null){
            return ResponseEntity.status(200).body(game);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/gamesMuseum/{museumId}/games")
    ResponseEntity<List<Game>> getGamesByMuseums(@PathVariable("museumId") int museumId){
        log.info("searching {}", museumId);
        GamesMuseum gamesMuseum = gameMuseumService.getMuseumsById(museumId);
        if(gamesMuseum == null){
            return ResponseEntity.notFound().build();
        }
        else {
            List<Game> games = gameMuseumService.getGamesInMuseum(gamesMuseum);
            log.info("found {} games with museum {}", games.size(), gamesMuseum.getName() );
            return ResponseEntity.ok(games);
        }
    }
    @PostMapping("/games")
    ResponseEntity<?> addGame(@Validated @RequestBody GameDTO gameDTO, Errors errors){

        log.info("add new game {}", gameDTO);

        if(errors.hasErrors()){
            return ResponseEntity.badRequest().build();
        }
        Game game = new Game();
        game.setTitle(gameDTO.getTitle());
        game.setRating(gameDTO.getRating());
        game.setProducent(gameService.getProducentById(gameDTO.getProducentId()));
        game = gameService.addGame(game);
        return ResponseEntity.
                created(
                        ServletUriComponentsBuilder
                                .fromCurrentRequestUri()
                                .path("/"+game.getId())
                                .build()
                                .toUri())
                .body(game);
    }
}
