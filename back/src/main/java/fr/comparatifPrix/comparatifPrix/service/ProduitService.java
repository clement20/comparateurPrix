package fr.comparatifPrix.comparatifPrix.service;

import fr.comparatifPrix.comparatifPrix.model.Produit;
import fr.comparatifPrix.comparatifPrix.model.RelevePrix;
import fr.comparatifPrix.comparatifPrix.model.dto.ProduitDTO;
import fr.comparatifPrix.comparatifPrix.repository.ProduitRepository;
import fr.comparatifPrix.comparatifPrix.repository.RelevePrixRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
//            produit.setPrixMoinsCher(
//                    releves.stream()
//                            .filter(releve->releve.getProduit().getId().equals(produit.getId()))
//                            .map(RelevePrix::getPrix)
//                            .max(Double::compareTo).orElse(null));
//            produit.setPrixMoyen(
//                    releves.stream()
//                            .filter(releve->releve.getProduit().getId().equals(produit.getId()))
//                            .map(RelevePrix::getPrix)
//                            .ave).orElse(null));
//        });
            //produit.setPrixMoyen(relevePrixRepository.getPrixMoyenByIdProduit(produit.getId()));
            produit.setPrixMoyen(relevePrixRepository.getPrixMoyenByIdProduit(produit.getId()));
            RelevePrix relevePrixMoinsCher = relevePrixRepository.getRelevePrixMoinsCherByIdProduit(produit.getId());
            produit.setPrixMoinsCher(relevePrixMoinsCher.getPrix());
            produit.setNomEnseigneMoinsChere(relevePrixMoinsCher.getEnseigne().getNom());
        });
        return resultats;
    }
}
