package cydrownia.repository.data;

import cydrownia.model.Cydr;
import cydrownia.repository.CydrDao;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Primary
@Repository
@RequiredArgsConstructor
public class DataCydrDao implements CydrDao {

    private final CydrRepository cydrRepository;

    @Override
    public List<Cydr> findAll() {
        return cydrRepository.findAll();
    }

    @Override
    public void add(Cydr cydr) {
        cydrRepository.save(cydr);
    }

    @Override
    public Cydr findByName(String nazwa) {
        return cydrRepository.findByNazwa(nazwa);
    }
}
