package fr.comparatifPrix.comparatifPrix.controller;

import fr.comparatifPrix.comparatifPrix.model.Produit;
import fr.comparatifPrix.comparatifPrix.model.dto.ProduitDTO;
import fr.comparatifPrix.comparatifPrix.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @GetMapping("/produits")
    public Iterable<ProduitDTO> getProduits() {
        return produitService.getProduits();
    }
}
