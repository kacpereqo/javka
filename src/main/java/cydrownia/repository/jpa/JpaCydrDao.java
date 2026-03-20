package cydrownia.repository.jpa;

import cydrownia.model.Cydr;
import cydrownia.repository.CydrRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public class JpaCydrDao implements CydrRepository {

    private final EntityManager entityManager;

    public JpaCydrDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Cydr> findAll() {
        return entityManager.createQuery("SELECT c FROM Cydr c", Cydr.class).getResultList();
    }

    @Override
    @Transactional
    public void add(Cydr cydr) {
        entityManager.persist(cydr);
    }

    @Override
    public Cydr findByName(String nazwa) {
        return entityManager.createQuery("SELECT c FROM Cydr c WHERE c.nazwa = :nazwa", Cydr.class)
                .setParameter("nazwa", nazwa)
                .getResultStream()
                .findFirst()
                .orElse(null);
    }
}