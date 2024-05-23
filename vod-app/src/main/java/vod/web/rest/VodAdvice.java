package vod.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice(basePackages = "vod.web.rest")
@RequiredArgsConstructor
public class VodAdvice {

    private final GameMuseumValidator gMvalidator;
    private final GameValidator gValidator;

    @InitBinder("gamesMuseum")
    void initBinderForMuseum(WebDataBinder binder){binder.addValidators(gMvalidator);}

    @InitBinder("gameDTO")
    void initBinderForGame(WebDataBinder binder){binder.addValidators(gValidator);}

    @ExceptionHandler(IllegalArgumentException.class)
    ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e){
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(e.getMessage());
    }
    @ExceptionHandler(Exception.class)
    ResponseEntity<String> handleException(Exception e){
        return ResponseEntity.status(HttpStatus.LOOP_DETECTED).body(e.getMessage());
    }
}
