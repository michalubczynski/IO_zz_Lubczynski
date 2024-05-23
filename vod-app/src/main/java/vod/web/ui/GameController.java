package vod.web.ui;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vod.model.Game;
import vod.model.GamesMuseum;
import vod.service.GameMuseumService;
import vod.service.GameService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class GameController {
    private final GameMuseumService gameMuseumService;
    private final GameService gameService;

    @GetMapping("/games")
    String getGames(
            Model model,
            @RequestParam(value = "museumId", required = false) Integer museumId
    ){
        if(museumId != null){
            GamesMuseum gamemuseum = gameMuseumService.getMuseumsById(museumId);
            List<Game> games = gameMuseumService.getGamesInMuseum(gamemuseum);
            model.addAttribute("games",games);
            model.addAttribute("title", "Games in museum '" + gamemuseum.getName() + "'");

        }
        else{
            List<Game> games = gameService.getAllGames();
            model.addAttribute("games", games);
            model.addAttribute("title", "Games");
        }

        return "gamesView";
    }
}
