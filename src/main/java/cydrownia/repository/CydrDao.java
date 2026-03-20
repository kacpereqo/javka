package cydrownia.repository;

import cydrownia.model.Cydr;
import java.util.List;

public interface CydrDao {
    List<Cydr> findAll();
    void add(Cydr cydr);
    Cydr findByName(String nazwa);
}