package cydrownia.model;


import jakarta.validation.constraints.*;

public class Cydr {

    @PositiveOrZero
    private int id;

    @NotBlank
    @Size(min = 2, max = 100)
    private String nazwa;

    @NotBlank
    private String styl;

    @Positive
    private double cena;

    @NotNull
    private boolean dostepny;

    public Cydr(int id, String nazwa, String styl, double cena) {
        this.id = id;
        this.nazwa = nazwa;
        this.styl = styl;
        this.cena = cena;
        this.dostepny = true; // domyślnie dostępny
    }

    public Cydr() {
    }

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


    @Override
    public String toString() {
        return "Cydr{" +
                "nazwa='" + nazwa + '\'' +
                ", cena=" + cena +
                ", dostepny=" + dostepny +
                '}';
    }
}