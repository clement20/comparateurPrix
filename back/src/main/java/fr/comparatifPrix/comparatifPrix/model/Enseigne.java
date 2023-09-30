package fr.comparatifPrix.comparatifPrix.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Enseigne {
    @Id
    private int id;

    private String nom;

    private String photo;
}
