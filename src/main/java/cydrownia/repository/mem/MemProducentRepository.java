package cydrownia.repository.mem;

import cydrownia.model.Producent;
import cydrownia.repository.ProducentRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemProducentRepository implements ProducentRepository {

    private List<Producent> db = new ArrayList<>();

    public MemProducentRepository() {
        db.add(new Producent(1, "Cydr Lubelski", "Duży producent"));
        db.add(new Producent(2, "Cydr Chyliczki", "Rzemieślniczy"));
    }

    @Override
    public List<Producent> findAll() {
        return db;
    }

    @Override
    public Producent findByName(String nazwa) {
        return db.stream()
                .filter(p -> p.getNazwa().equalsIgnoreCase(nazwa))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void add(Producent producent) {
        db.add(producent);
    }
}