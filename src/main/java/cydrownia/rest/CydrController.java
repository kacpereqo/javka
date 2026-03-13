package cydrownia.rest;

import cydrownia.model.Cydr;
import cydrownia.service.CydrService;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ciders")
public class CydrController {



    private final CydrService cydrService;
    private final CydrValidator validator;

    public CydrController(MessageSource messageSource, CydrService cydrService, CydrValidator validator) {
        this.cydrService = cydrService;
        this.validator = validator;
    }

    @InitBinder
    void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @GetMapping
    public List<Cydr> getAll() {
        return cydrService.getAllCydrs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cydr> getById(@PathVariable int id) {
        Cydr cydr = cydrService.getCydrById(id);

        if (cydr != null) {
            return ResponseEntity.ok(cydr);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public ResponseEntity<?> addCydr(@Validated @RequestBody Cydr newCydr, BindingResult bindingResult, Errors errors) {

        if (bindingResult.hasErrors()) {
            String errorMessage = errors.getAllErrors().stream()
                    .map(oe->oe.toString())
                    .reduce("errors:\n", (accu,oe) -> accu+oe+"\n");
            return ResponseEntity.badRequest().body(errorMessage);
        }

//        if (bindingResult.hasErrors()) {
//            String errorMessage = errors.getAllErrors().stream()
//                    .map(oe->messageSource.getMessage(oe.getCode(), new Object[0], locale))
//                    .reduce("errors:\n", (accu,oe) -> accu+oe+"\n");
//            return ResponseEntity.badRequest().body(errorMessage);
//        }


            cydrService.addCydr(newCydr);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCydr);
    }
}