package vod.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vod.model.GamesMuseum;
import vod.service.GameMuseumService;

@Component
@RequiredArgsConstructor
public class GameMuseumValidator implements Validator {
    private final GameMuseumService museumService;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(GamesMuseum.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        GamesMuseum validatedMuseum = (GamesMuseum) target;

        boolean duplicated = museumService.getAllMuseums().stream()
                .anyMatch(mus -> mus.getName().equalsIgnoreCase(validatedMuseum.getName()));
        if(duplicated){
            errors.rejectValue("name", "museum.name.duplicated");
        }
    }
}
