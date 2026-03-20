package cydrownia.repository.mem;

import cydrownia.model.Zamowienie;
import cydrownia.repository.ZamowieniaDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MemZamowienieRepository implements ZamowieniaDao {

    @Override
    public List<Zamowienie> findAll() {
        return SampleData.zamowienia;
    }

    @Override
    public void add(Zamowienie zamowienie) {
        SampleData.zamowienia.add(zamowienie);
    }
}