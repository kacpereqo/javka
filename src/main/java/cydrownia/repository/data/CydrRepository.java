package cydrownia.repository.data;

import cydrownia.model.Cydr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CydrRepository extends JpaRepository<Cydr, Integer> {

    Cydr findByNazwa(String nazwa);
}
