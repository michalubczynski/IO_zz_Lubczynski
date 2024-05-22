package vod.web.rest;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;
import vod.model.Game;
import vod.model.GamesMuseum;
import vod.service.GameMuseumService;
import vod.service.GameService;

import java.util.List;
import java.util.Locale;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("webapi")
public class GameMuseumRest {

    private final GameMuseumService gameMuseumService;
    private final GameService gameService;
    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;
    private final GameMuseumValidator gameMuseumValidator;


    @GetMapping("/museums")
    List<GamesMuseum> getMuseums(@RequestParam(value = "phrase", required = false)String phrase,
                                 @RequestHeader(value = "custom-header", required = false)String customHeader,
                                 @CookieValue(value = "some-cookie", required = false)String someCookie){
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
    ResponseEntity<?> addMuseum(@Validated @RequestBody GamesMuseum museum, Errors errors, HttpServletRequest request){
        log.info("add new museum {}", museum);

        if(errors.hasErrors()){
            Locale locale = localeResolver.resolveLocale(request);
            String errorMessage = errors.getAllErrors().stream()
                    .map(oe->messageSource.getMessage(oe.getCode(), new Object[0], locale))
                    .reduce("errors:\n", (accu,oe) -> accu+oe + "\n");
            return ResponseEntity.badRequest().body(errorMessage);
        }
        museum = gameMuseumService.addMuseum(museum);
        return ResponseEntity.status(HttpStatus.CREATED).body(museum);
    }
}
