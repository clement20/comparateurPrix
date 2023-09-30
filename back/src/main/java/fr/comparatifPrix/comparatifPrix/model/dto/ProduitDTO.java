package fr.comparatifPrix.comparatifPrix.model.dto;

import fr.comparatifPrix.comparatifPrix.model.Enseigne;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class ProduitDTO {
    private int id;
    private String nom;
    private String photo;
    private String typePrix;
    private List<PrixDTO> prixMoinsChers = new ArrayList<>();
    private List<PrixDTO> prixPlusChers = new ArrayList<>();
    private Double prixMoyen;
    private Date dateMajReleve;

}
