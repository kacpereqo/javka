package cydrownia.service.impl;

import cydrownia.model.Cydr;
import cydrownia.model.Producent;
import cydrownia.repository.CydrRepository;
import cydrownia.service.CydrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class CydrServiceBean implements CydrService {

    private final Logger logger = Logger.getLogger(CydrServiceBean.class.getName());

    private final CydrRepository cydrRepository;

    @Autowired
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
        return cydrRepository.findAll().stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Cydr> getCydrsByProducent(Producent p) {
        logger.info("Szukanie cydrów producenta: " + p.getNazwa());
        return p.getOferta();
    }

    @Override
    public void addCydr(Cydr c) {
        logger.info("Dodawanie nowego cydru: " + c.getNazwa());
        cydrRepository.add(c);
    }
}