package cydrownia.repository.mem;

import cydrownia.model.Cydr;
import cydrownia.model.Producent;
import cydrownia.model.Zamowienie;

import java.util.ArrayList;
import java.util.List;

public class SampleData {
    public static List<Cydr> cydry = new ArrayList<>();
    public static List<Producent> producenci = new ArrayList<>();
    public static List<Zamowienie> zamowienia = new ArrayList<>();

    static {
        // 1. Tworzymy Producentów
        Producent p1 = new Producent(1, "Cydr Chyliczki", "Rzemieślniczy cydr z Mazowsza");
        Producent p2 = new Producent(2, "Cydr Lubelski", "Popularny cydr przemysłowy");
        Producent p3 = new Producent(3, "Kwaśne Jabłko", "Ekologiczna cydrownia z Warmii");

        producenci.add(p1);
        producenci.add(p2);
        producenci.add(p3);

        // 2. Tworzymy Cydry
        Cydr c1 = new Cydr(101, "Szara Reneta", "Wytrawny", 25.00);
        Cydr c2 = new Cydr(102, "Klasyczny", "Półsłodki", 12.50);
        Cydr c3 = new Cydr(103, "Lodowy", "Słodki/Deserowy", 45.00);

        cydry.add(c1);
        cydry.add(c2);
        cydry.add(c3);

        // 3. Budujemy relacje (wiele do wielu)
        // Przypisanie producentów do cydrów
        c1.addProducent(p1);
        c3.addProducent(p1); // Chyliczki robią Szarą Renetę i Lodowy
        c2.addProducent(p2); // Lubelski robi Klasyczny

        // Przypisanie cydrów do producentów (relacja zwrotna)
        p1.addCydr(c1);
        p1.addCydr(c3);
        p2.addCydr(c2);

        // 4. Tworzymy przykładowe Zamówienia
        Zamowienie z1 = new Zamowienie(501, "ORD-001", "NOWE");
        z1.addProdukt(c1);
        z1.addProdukt(c3); // Ktoś zamówił dwa drogie cydry

        Zamowienie z2 = new Zamowienie(502, "ORD-002", "WYSŁANE");
        z2.addProdukt(c2);

        zamowienia.add(z1);
        zamowienia.add(z2);

        // Relacja zwrotna: Cydr wie w jakich jest zamówieniach
        c1.addZamowienie(z1);
        c3.addZamowienie(z1);
        c2.addZamowienie(z2);
    }
}