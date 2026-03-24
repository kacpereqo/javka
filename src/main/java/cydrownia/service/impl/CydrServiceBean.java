package cydrownia.service.impl;

import cydrownia.model.Cydr;
import cydrownia.model.Producent;
import cydrownia.repository.CydrDao;
import cydrownia.service.CydrService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;


@Service
@Slf4j
public class CydrServiceBean implements CydrService {

    private final Logger logger = Logger.getLogger(CydrServiceBean.class.getName());

    private final CydrDao cydrRepository;

    @Autowired
    public CydrServiceBean(CydrDao cydrRepository) {
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

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void addCydr(Cydr c) {
        logger.info("Dodawanie nowego cydru: " + c.getNazwa());

        Authentication auth = org.springframework.security.core.context.SecurityContextHolder.getContext().getAuthentication();
        log.info("authentication {}", auth.getName());
        log.info("authorities {}", auth.getAuthorities());

        cydrRepository.add(c);
    }
}