package cydrownia.service;

import cydrownia.model.Cydr;
import cydrownia.model.Producent;

import java.util.List;

public interface CydrService {
    // Odczyt
    List<Cydr> getAllCydrs();
    Cydr getCydrById(int id);
    List<Cydr> getCydrsByProducent(Producent p);

    // Zapis
    void addCydr(Cydr c);
}