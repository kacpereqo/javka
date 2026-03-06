package cydrownia.service.impl;

import cydrownia.model.Cydr;
import cydrownia.model.Producent;
import cydrownia.repository.ProducentRepository;
import cydrownia.service.ProducentService;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class ProducentServiceBean implements ProducentService {

    private final Logger logger = Logger.getLogger(ProducentServiceBean.class.getName());

    // Wstrzykujemy repozytorium producentów
    private final ProducentRepository producentRepository;

    public ProducentServiceBean(ProducentRepository producentRepository) {
        this.producentRepository = producentRepository;
    }

    @Override
    public List<Producent> getAllProducents() {
        logger.info("Pobieranie wszystkich producentów");
        return producentRepository.findAll();
    }

    @Override
    public Producent getProducentById(int id) {
        logger.info("Szukanie producenta o ID: " + id);
        return producentRepository.findAll().stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Producent> getProducentsOfCydr(Cydr c) {
        logger.info("Pobieranie producentów dla cydru: " + c.getNazwa());
        // Możemy skorzystać z Cydru, jeśli ma wypełnioną listę (podejście obiektowe)
        if (c.getProducenci() != null && !c.getProducenci().isEmpty()) {
            return c.getProducenci();
        }

        // Lub alternatywnie przeszukać repozytorium (podejście bazodanowe/zachowawcze)
        return producentRepository.findAll().stream()
                .filter(p -> p.getOferta().stream().anyMatch(cydr -> cydr.getId() == c.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public void addProducent(Producent p) {
        logger.info("Rejestracja nowego producenta: " + p.getNazwa());
        producentRepository.add(p);
    }
}