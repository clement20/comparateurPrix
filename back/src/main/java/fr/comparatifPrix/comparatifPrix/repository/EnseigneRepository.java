package fr.comparatifPrix.comparatifPrix.repository;

import fr.comparatifPrix.comparatifPrix.model.Enseigne;
import fr.comparatifPrix.comparatifPrix.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnseigneRepository extends JpaRepository<Enseigne, Integer> {
}
