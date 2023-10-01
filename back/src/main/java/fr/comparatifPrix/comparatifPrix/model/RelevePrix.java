package fr.comparatifPrix.comparatifPrix.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@IdClass(RelevePrixID.class)
public class RelevePrix {
    @Id
    @ManyToOne
    @JoinColumn(name = "produit")
    private Produit produit;
    @Id
    @ManyToOne()
    @JoinColumn(name = "enseigne")
    private Enseigne enseigne;
    @Id
    private Date date;

    private double prix;
}
