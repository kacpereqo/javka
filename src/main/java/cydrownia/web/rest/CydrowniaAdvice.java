package cydrownia.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
@RequiredArgsConstructor
public class CydrowniaAdvice {
    private final CydrValidator cydrValidator;
    private final ProducentValidator producentValidator;

    @InitBinder("cydrDTO")
    void InitBinderForCydr(WebDataBinder binder){
        binder.addValidators(cydrValidator);
    }

    @InitBinder("producent")
    void InitBinderForProducent(WebDataBinder binder){
        binder.addValidators(producentValidator);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e){
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(e.getMessage());
    }
}
