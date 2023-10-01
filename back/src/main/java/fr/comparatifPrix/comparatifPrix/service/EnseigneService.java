package fr.comparatifPrix.comparatifPrix.service;

import fr.comparatifPrix.comparatifPrix.model.Enseigne;
import fr.comparatifPrix.comparatifPrix.model.Produit;
import fr.comparatifPrix.comparatifPrix.model.RelevePrix;
import fr.comparatifPrix.comparatifPrix.model.dto.EnseigneDTO;
import fr.comparatifPrix.comparatifPrix.model.dto.PrixDTO;
import fr.comparatifPrix.comparatifPrix.model.dto.ProduitDTO;
import fr.comparatifPrix.comparatifPrix.repository.EnseigneRepository;
import fr.comparatifPrix.comparatifPrix.repository.ProduitRepository;
import fr.comparatifPrix.comparatifPrix.repository.RelevePrixRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnseigneService {

    @Autowired
    private EnseigneRepository enseigneRepository;

    @Autowired
    private RelevePrixRepository relevePrixRepository;

    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private ModelMapper modelMapper;
    public List<EnseigneDTO> getEnseignes() {
        List<Enseigne> enseignes = enseigneRepository.findAll();
        List<RelevePrix> releves = relevePrixRepository.findAll();
        List<EnseigneDTO> resultats = enseignes.stream().map(enseigne->modelMapper.map(enseigne,EnseigneDTO.class)).toList();
        resultats.forEach(resultat -> {
            resultat.setEcartALaMoyenne(getEcartALaMoyenne(resultat.getId()));
        });
        return resultats;
    }

    private Double getEcartALaMoyenne(int idEnseigne) {
        List<Double> moyennes = new ArrayList<>();
        produitRepository.findAll().forEach( produit-> {
            Double montantProduitEnseigne = relevePrixRepository.getMontantParProduitParEnseigne(produit.getId(),idEnseigne);
            Double moyenneProduitAutresEnseignes = relevePrixRepository.getMoyenneAutresEnseignesParProduit(produit.getId(),idEnseigne);
            moyennes.add((moyenneProduitAutresEnseignes/montantProduitEnseigne)-1);
        });
        DoubleSummaryStatistics doubleSummaryStatistics = moyennes.stream().collect(Collectors.summarizingDouble(Double::doubleValue));
        return doubleSummaryStatistics.getAverage();
    }
}
