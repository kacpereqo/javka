package cydrownia.repository.jpa;

import cydrownia.model.Producent;
import cydrownia.repository.ProducentRepository;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Primary
public class JpaProducentDao implements ProducentRepository {

    private final EntityManager entityManager;

    public JpaProducentDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Producent> findAll() {
        return entityManager.createQuery(
                        "SELECT DISTINCT p FROM Producent p LEFT JOIN FETCH p.oferta", Producent.class)
                .getResultList();
    }

    @Override
    @Transactional
    public void add(Producent producent) {
        if (producent.getId() == 0) {
            entityManager.persist(producent);
        } else {
            entityManager.merge(producent);
        }
    }

    @Override
    public Producent findByName(String nazwa) {
        return entityManager.createQuery(
                        "SELECT p FROM Producent p WHERE p.nazwa = :nazwa", Producent.class)
                .setParameter("nazwa", nazwa)
                .getResultStream()
                .findFirst()
                .orElse(null);
    }

    public Producent findById(int id) {
        return entityManager.find(Producent.class, id);
    }
}