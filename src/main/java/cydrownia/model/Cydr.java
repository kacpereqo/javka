package cydrownia.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cydr {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PositiveOrZero
    private int id;

    @NotBlank
    @Size(min = 2, max = 100)
    @Column(nullable = false)
    private String nazwa;

    @NotBlank
    @Column(nullable = false)
    private String styl;

    @Positive
    @Column(nullable = false)
    private double cena;

    @NotNull
    private boolean dostepny = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producent_id")
    private Producent producent;

    public Cydr(int id, String nazwa, String styl, double cena) {
        this.id = id;
        this.nazwa = nazwa;
        this.styl = styl;
        this.cena = cena;
    }
}