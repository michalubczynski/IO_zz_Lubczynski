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
public class GameMuseumController {
    private final GameMuseumService gameMuseumService;
    private final GameService gameService;

    @GetMapping("/museums")
    String getMuseums(
            Model model,
            @RequestParam(value = "gameId", required = false) Integer gameId,
            @RequestParam(value = "producentId", required = false) Integer producentId
            ){
        if(gameId != null){
            Game game = gameService.getGameById(gameId);
            List<GamesMuseum> gamesMuseums = gameMuseumService.getMuseumByGame(game);
            model.addAttribute("gameMuseums",gamesMuseums);
            model.addAttribute("title", "GamesMuseums with '" + game.getTitle() + "'");

        }else{
            List<GamesMuseum> gamesMuseums = gameMuseumService.getAllMuseums();
            model.addAttribute("gameMuseums",gamesMuseums);
            model.addAttribute("title", "GamesMuseums");
        }

        return "gameMuseumView";
    }
}
