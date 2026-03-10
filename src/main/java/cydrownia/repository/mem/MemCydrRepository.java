package cydrownia.repository.mem;

import cydrownia.model.Cydr;
import cydrownia.repository.CydrRepository;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Component
public class MemCydrRepository implements CydrRepository {

    @Override
    public List<Cydr> findAll() {
        return SampleData.cydry;
    }

    @Override
    public void add(Cydr cydr) {
        SampleData.cydry.add(cydr);
    }

    @Override
    public Cydr findByName(String nazwa) {
        return SampleData.cydry.stream()
                .filter(c -> c.getNazwa().equalsIgnoreCase(nazwa))
                .findFirst()
                .orElse(null);
    }
}