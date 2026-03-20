package cydrownia.repository.mem;

import cydrownia.model.Cydr;
import cydrownia.repository.CydrDao;

import java.util.List;

//@Component
public class MemCydrRepository implements CydrDao {

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