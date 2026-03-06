package cydrownia.model;

import java.util.ArrayList;
import java.util.List;

public class Cydr {

    private int id;
    private String nazwa;
    private String styl; // np. "Półsłodki", "Musujący"
    private double cena;
    private boolean dostepny;

    // Relacja: Cydr ma producenta (lub wielu, jeśli to kooperacja)
    private List<Producent> producenci = new ArrayList<>();

    // Relacja: Cydr znajduje się w wielu zamówieniach klientów
    private List<Zamowienie> zamowienia = new ArrayList<>();

    public Cydr(int id, String nazwa, String styl, double cena) {
        this.id = id;
        this.nazwa = nazwa;
        this.styl = styl;
        this.cena = cena;
        this.dostepny = true; // domyślnie dostępny
    }

    public Cydr() {
    }

    // Gettery i Settery
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNazwa() { return nazwa; }
    public void setNazwa(String nazwa) { this.nazwa = nazwa; }

    public String getStyl() { return styl; }
    public void setStyl(String styl) { this.styl = styl; }

    public double getCena() { return cena; }
    public void setCena(double cena) { this.cena = cena; }

    public boolean isDostepny() { return dostepny; }
    public void setDostepny(boolean dostepny) { this.dostepny = dostepny; }

    public List<Producent> getProducenci() { return producenci; }
    public void setProducenci(List<Producent> producenci) { this.producenci = producenci; }

    public List<Zamowienie> getZamowienia() { return zamowienia; }
    public void setZamowienia(List<Zamowienie> zamowienia) { this.zamowienia = zamowienia; }

    // Metody pomocnicze
    public void addProducent(Producent p) {
        this.producenci.add(p);
    }

    public void addZamowienie(Zamowienie z) {
        this.zamowienia.add(z);
    }

    @Override
    public String toString() {
        return "Cydr{" +
                "nazwa='" + nazwa + '\'' +
                ", cena=" + cena +
                ", dostepny=" + dostepny +
                '}';
    }
}