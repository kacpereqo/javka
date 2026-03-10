package cydrownia.repository;

import cydrownia.model.Producent;
import java.util.List;

public interface ProducentRepository {
    List<Producent> findAll();
    Producent findByName(String nazwa);

    void add(Producent producent);
}