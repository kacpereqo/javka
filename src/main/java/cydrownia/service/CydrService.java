package cydrownia.service;

import cydrownia.model.Cydr;
import cydrownia.model.Producent;

import java.util.List;

public interface CydrService {
    List<Cydr> getAllCydrs();
    Cydr getCydrById(int id);
    List<Cydr> getCydrsByProducent(Producent p);

    void addCydr(Cydr c);
}