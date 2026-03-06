package cydrownia.service;

import cydrownia.model.Cydr;
import cydrownia.model.Producent;

import java.util.List;

public interface ProducentService {
    // Odczyt
    List<Producent> getAllProducents();
    Producent getProducentById(int id);
    List<Producent> getProducentsOfCydr(Cydr c);

    // Zapis
    void addProducent(Producent p);
}