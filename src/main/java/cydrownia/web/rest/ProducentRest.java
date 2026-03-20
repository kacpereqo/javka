package cydrownia.web.rest;

import cydrownia.model.Producent;
import cydrownia.service.ProducentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producers")
public class ProducentRest {

    private final ProducentService producentService;

    public ProducentRest(ProducentService producentService) {
        this.producentService = producentService;
    }

    @GetMapping
    public List<Producent> getAll() {
        return producentService.getAllProducents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producent> getById(@PathVariable int id) {
        Producent producent = producentService.getProducentById(id);

        if (producent != null) {
            return ResponseEntity.ok(producent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> addProducent(@RequestBody @Validated Producent newProducent, Errors errors) {

        if (errors.hasErrors()){
            StringBuilder sb = new StringBuilder();
            errors.getAllErrors().forEach(e -> sb.append(e.getDefaultMessage()).append("\n"));
            return ResponseEntity.badRequest().body(sb.toString());
        }

        producentService.addProducent(newProducent);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProducent);
    }
}
