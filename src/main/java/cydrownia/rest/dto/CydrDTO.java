package cydrownia.rest.dto;

import lombok.Data;

@Data
public class CydrDTO {
    private int id;
    private String nazwa;
    private String styl;
    private double cena;
    private boolean dostepny;
}
