package vod.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vod.model.Producent;
import vod.service.GameService;
import vod.web.rest.dto.GameDTO;

@Component
@RequiredArgsConstructor
public class GameValidator implements Validator {

    private final GameService gameService;
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(GameDTO.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        GameDTO game = (GameDTO) target;
        Producent producent = gameService.getProducentById(game.getProducentId());
        if(producent==null){
            errors.rejectValue("producentId","game.producent.missing");
        }
    }
}
