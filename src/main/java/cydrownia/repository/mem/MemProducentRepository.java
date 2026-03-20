package cydrownia.repository.mem;

import cydrownia.model.Producent;
import cydrownia.repository.ProducentRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Component
public class MemProducentRepository implements ProducentRepository {

    @Override
    public List<Producent> findAll() {
        return SampleData.producenci;
    }

    @Override
    public Producent findByName(String nazwa) {
        return SampleData.producenci.stream()
                .filter(p -> p.getNazwa().equalsIgnoreCase(nazwa))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void add(Producent producent) {
        SampleData.producenci.add(producent);
    }
}