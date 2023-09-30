package fr.comparatifPrix.comparatifPrix.repository;

import fr.comparatifPrix.comparatifPrix.model.Produit;
import fr.comparatifPrix.comparatifPrix.model.RelevePrixID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, RelevePrixID> {
}
