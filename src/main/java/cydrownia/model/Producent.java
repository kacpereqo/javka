package cydrownia.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Producent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nazwa;

    private String opis;

    private String logo;

    @OneToMany(mappedBy = "producent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cydr> oferta = new ArrayList<>();

    public void addCydr(Cydr c) {
        oferta.add(c);
        c.setProducent(this);
    }

    public Producent(int id, String nazwa, String opis) {
        this.id = id;
        this.nazwa = nazwa;
        this.opis = opis;
    }
}