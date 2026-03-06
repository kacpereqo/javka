package cydrownia.model;

import java.util.ArrayList;
import java.util.List;

public class Producent {

    private int id;
    private String nazwa; // np. "Cydr Chyliczki"
    private String opis; // np. "Rzemieślnicza cydrownia z Mazowsza"

    // Lista cydrów oferowanych przez tego producenta
    private List<Cydr> oferta = new ArrayList<>();

    public Producent(int id, String nazwa, String opis) {
        this.id = id;
        this.nazwa = nazwa;
        this.opis = opis;
    }

    public Producent() {
    }

    // Gettery i Settery
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNazwa() { return nazwa; }
    public void setNazwa(String nazwa) { this.nazwa = nazwa; }

    public String getOpis() { return opis; }
    public void setOpis(String opis) { this.opis = opis; }

    public List<Cydr> getOferta() { return oferta; }
    public void setOferta(List<Cydr> oferta) { this.oferta = oferta; }

    public void addCydr(Cydr c) {
        this.oferta.add(c);
    }

    @Override
    public String toString() {
        return "Producent{" +
                "nazwa='" + nazwa + '\'' +
                ", opis='" + opis + '\'' +
                '}';
    }
}