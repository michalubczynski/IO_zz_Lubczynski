package museums.web;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import museums.dao.GameMuseumRepository;
import museums.model.Gamesmuseum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/webapi")
@RequiredArgsConstructor
public class GameMuseumRest {

    private final GameMuseumRepository gameMuseumRepository;

    @Value("http://localhost:8080/webapi")
    private String gameServiceUrl;

    @GetMapping("/museums")
    public List<Gamesmuseum> getMuseums() {
        log.info("about to retrieve all museums");
        List<Gamesmuseum> gamesmuseums = gameMuseumRepository.findAll();
        gamesmuseums.forEach(this::fillGameNames);
        return gamesmuseums;
    }

    @GetMapping("/games/{id}/museums")
    public List<Gamesmuseum> getGamesMuseumsByGame(@PathVariable int id) {
        log.info("about to retrieve museums by game {}", id);
        List<Gamesmuseum> gamesmuseums = gameMuseumRepository.findGamesmuseumsByGamesIsContaining(id);
        gamesmuseums.forEach(this::fillGameNames);
        return gamesmuseums;
    }

    private void fillGameNames(Gamesmuseum gamesmuseum) {
        gamesmuseum.getGames().forEach(gameId -> {
            try {
                RestTemplate restTemplate = new RestTemplate();
                ResponseEntity<GameDTO> responseEntity = restTemplate.exchange(
                        gameServiceUrl + "/games/" + gameId,
                        HttpMethod.GET,
                        HttpEntity.EMPTY,
                        GameDTO.class
                );
                GameDTO gameDTO = responseEntity.getBody();
                if (gameDTO != null) {
                    gamesmuseum.getGameNames().add(gameDTO.getTitle()); //important change from
                } else {
                    log.warn("GameDTO is null for game ID {}", gameId);
                }
            } catch (Exception e) {
                log.error("Failed to retrieve game details for game ID {}", gameId, e);
            }
        });
    }
    @Data
    static class GameDTO {
        private String title;
        private int producentId;
        private float rating;
    }

}

