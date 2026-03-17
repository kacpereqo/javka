package cydrownia.rest;

import cydrownia.model.Cydr;
import cydrownia.rest.dto.CydrDTO;
import cydrownia.service.CydrService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/ciders")
public class CydrController {



    private final CydrService cydrService;

    @GetMapping
    public List<Cydr> getAll(
            @RequestParam(value = "phrase", required = false) String phrase
    ) {

        if (phrase != null && phrase.equals("foo")){
            throw new IllegalArgumentException("foo");
        }

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
    public ResponseEntity<?> addCydr(@RequestBody @Validated CydrDTO cydrDTO, Errors errors) {

        if (errors.hasErrors()){
            return ResponseEntity.badRequest().build();
        }

        var newCydr  = new Cydr();
        newCydr.setNazwa(cydrDTO.getNazwa());
        newCydr.setCena(cydrDTO.getCena());
        newCydr.setDostepny(cydrDTO.isDostepny());
        newCydr.setStyl(cydrDTO.getStyl());

        cydrService.addCydr(newCydr);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCydr);
    }
}