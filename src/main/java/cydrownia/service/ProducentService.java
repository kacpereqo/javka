package cydrownia.service;

import cydrownia.model.Cydr;
import cydrownia.model.Producent;

import java.util.List;

public interface ProducentService {
    List<Producent> getAllProducents();
    Producent getProducentById(int id);
    List<Producent> getProducentsOfCydr(Cydr c);

    void addProducent(Producent p);
}