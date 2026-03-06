package cydrownia.repository;

import cydrownia.model.Cydr;
import java.util.List;

public interface CydrRepository {
    List<Cydr> findAll();
    void add(Cydr cydr);
    Cydr findByName(String nazwa);
}