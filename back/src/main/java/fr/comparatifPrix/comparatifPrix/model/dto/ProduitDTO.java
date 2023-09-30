package fr.comparatifPrix.comparatifPrix.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ProduitDTO {
    private int id;
    private String nom;
    private String photo;
    private String typePrix;
    private Double prixMoinsCher;
    private String nomEnseigneMoinsChere;
    private String photoEnseigneMoinsChere;
    private Double prixMoyen;
    private Date dateMajReleve;

}
