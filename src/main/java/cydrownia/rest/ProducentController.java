package cydrownia.rest;

import cydrownia.model.Producent;
import cydrownia.service.ProducentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/producers")
public class ProducentController {

    private final ProducentService producentService;

    public ProducentController(ProducentService producentService) {
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
}