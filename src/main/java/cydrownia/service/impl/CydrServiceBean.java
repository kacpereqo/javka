package cydrownia.service.impl;

import cydrownia.model.Cydr;
import cydrownia.model.Producent;
import cydrownia.repository.CydrRepository;
import cydrownia.service.CydrService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class CydrServiceBean implements CydrService {

    private final Logger logger = Logger.getLogger(CydrServiceBean.class.getName());

    // Wstrzykujemy repozytorium cydrów
    private final CydrRepository cydrRepository;

    public CydrServiceBean(CydrRepository cydrRepository) {
        this.cydrRepository = cydrRepository;
    }

    @Override
    public List<Cydr> getAllCydrs() {
        logger.info("Pobieranie wszystkich cydrów");
        return cydrRepository.findAll();
    }

    @Override
    public Cydr getCydrById(int id) {
        logger.info("Szukanie cydru o ID: " + id);
        // Ponieważ repozytorium nie ma findById, filtrujemy strumieniem w pamięci
        return cydrRepository.findAll().stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Cydr> getCydrsByProducent(Producent p) {
        logger.info("Szukanie cydrów producenta: " + p.getNazwa());
        // Filtrujemy wszystkie cydry, sprawdzając czy na ich liście producentów znajduje się ten szukany
        // (porównujemy po ID, aby uniknąć problemów z referencjami obiektów)
        return cydrRepository.findAll().stream()
                .filter(cydr -> cydr.getProducenci().stream()
                        .anyMatch(prod -> prod.getId() == p.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public void addCydr(Cydr c) {
        logger.info("Dodawanie nowego cydru: " + c.getNazwa());
        cydrRepository.add(c);
    }
}