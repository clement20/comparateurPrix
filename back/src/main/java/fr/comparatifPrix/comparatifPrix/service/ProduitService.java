package fr.comparatifPrix.comparatifPrix.service;

import fr.comparatifPrix.comparatifPrix.model.Produit;
import fr.comparatifPrix.comparatifPrix.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;
    public List<Produit> getProduits() {
        return produitRepository.findAll();
    }
}
