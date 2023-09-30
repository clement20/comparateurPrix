package fr.comparatifPrix.comparatifPrix.service;

import fr.comparatifPrix.comparatifPrix.model.Enseigne;
import fr.comparatifPrix.comparatifPrix.model.Produit;
import fr.comparatifPrix.comparatifPrix.model.RelevePrix;
import fr.comparatifPrix.comparatifPrix.model.dto.PrixDTO;
import fr.comparatifPrix.comparatifPrix.model.dto.ProduitDTO;
import fr.comparatifPrix.comparatifPrix.repository.ProduitRepository;
import fr.comparatifPrix.comparatifPrix.repository.RelevePrixRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private RelevePrixRepository relevePrixRepository;

    @Autowired
    private ModelMapper modelMapper;
    public List<ProduitDTO> getProduits() {
        List<Produit> produits = produitRepository.findAll();
        List<RelevePrix> releves = relevePrixRepository.findAll();
        List<ProduitDTO> resultats = produits.stream().map(produit->modelMapper.map(produit,ProduitDTO.class)).toList();
        resultats.forEach( produit-> {
            produit.setPrixMoyen(relevePrixRepository.getPrixMoyenByIdProduit(produit.getId()));
            remplitPrixPlusChers(produit);
            remplitPrixMoinsChers(produit);
        });
        return resultats;
    }

    private void remplitPrixPlusChers(ProduitDTO produit) {
        List<PrixDTO> prixPlusChers = new ArrayList<>();
        List<RelevePrix> relevesPrixPlusCher = relevePrixRepository.getRelevePrixPlusCherByIdProduit(produit.getId());
        relevesPrixPlusCher.forEach(relevePrix -> {
            PrixDTO prixDTO = new PrixDTO();
            prixDTO.setNomEnseigne(relevePrix.getEnseigne().getNom());
            prixDTO.setPhotoEnseigne(relevePrix.getEnseigne().getPhoto());
            prixDTO.setMontant(relevePrix.getPrix());
            prixPlusChers.add(prixDTO);
        });
        produit.setPrixPlusChers(prixPlusChers);
        produit.setDateMajReleve(relevesPrixPlusCher.get(0).getDate());
    }

    private void remplitPrixMoinsChers(ProduitDTO produit) {
        List<PrixDTO> prixMoinsChers = new ArrayList<>();
        List<RelevePrix> relevesPrixMoinsCher = relevePrixRepository.getRelevesPrixMoinsCherByIdProduit(produit.getId());
        relevesPrixMoinsCher.forEach(relevePrix -> {
            PrixDTO prixDTO = new PrixDTO();
            prixDTO.setNomEnseigne(relevePrix.getEnseigne().getNom());
            prixDTO.setPhotoEnseigne(relevePrix.getEnseigne().getPhoto());
            prixDTO.setMontant(relevePrix.getPrix());
            prixMoinsChers.add(prixDTO);
        });
        produit.setPrixMoinsChers(prixMoinsChers);
    }
}
