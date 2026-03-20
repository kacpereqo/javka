package cydrownia.repository.data;

import cydrownia.model.Cydr;
import cydrownia.model.Producent;
import cydrownia.repository.CydrDao;
import cydrownia.repository.ProducentDao;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Primary
@Repository
@RequiredArgsConstructor
public class DataProducentDao implements ProducentDao {

    private final ProducentRepository producentRepository;

    @Override
    public List<Producent> findAll() {
        return producentRepository.findAll();
    }

    @Override
    public Producent findByName(String nazwa) {
        return producentRepository.findByNazwa(nazwa);
    }

    @Override
    public void add(Producent producent) {
        producentRepository.save(producent);
    }
}
