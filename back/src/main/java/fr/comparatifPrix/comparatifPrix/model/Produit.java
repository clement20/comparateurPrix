package fr.comparatifPrix.comparatifPrix.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Produit {

    @Id
    private String id;
    private String nom;
    private String photo;
    private String typePrix;
    private Date dateMaj;

}
