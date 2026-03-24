package cydrownia.model;

import java.util.ArrayList;
import java.util.List;

public class Zamowienie {

    private int id;
    private String numerZamowienia; // np. "ORD-2023-001"
    private String status; // np. "NOWE", "WYSŁANE", "DOSTARCZONE"

    private List<Cydr> produkty = new ArrayList<>();

    public Zamowienie(int id, String numerZamowienia, String status) {
        this.id = id;
        this.numerZamowienia = numerZamowienia;
        this.status = status;
    }

    public Zamowienie() {
    }

    // Gettery i Settery
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNumerZamowienia() { return numerZamowienia; }
    public void setNumerZamowienia(String numerZamowienia) { this.numerZamowienia = numerZamowienia; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public List<Cydr> getProdukty() { return produkty; }
    public void setProdukty(List<Cydr> produkty) { this.produkty = produkty; }

    public void addProdukt(Cydr c) {
        this.produkty.add(c);
    }

    @Override
    public String toString() {
        return "Zamowienie{" +
                "numer='" + numerZamowienia + '\'' +
                ", status='" + status + '\'' +
                ", iloscProduktow=" + produkty.size() +
                '}';
    }
}