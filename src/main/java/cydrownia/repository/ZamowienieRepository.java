package cydrownia.repository;

import cydrownia.model.Zamowienie;
import java.util.List;

public interface ZamowienieRepository {
    List<Zamowienie> findAll();
    void add(Zamowienie zamowienie);
}