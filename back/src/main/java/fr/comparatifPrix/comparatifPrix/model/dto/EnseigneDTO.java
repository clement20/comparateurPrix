package fr.comparatifPrix.comparatifPrix.model.dto;

import lombok.Data;

@Data
public class EnseigneDTO {
    private int id;
    private String nom;
    private String photo;
    private Double ecartALaMoyenne;
    private int nbProduitsMoinsChers;
    private int nbProduitsPlusChers;
    private int nbTotalProduits;
}
