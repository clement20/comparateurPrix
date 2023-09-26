package fr.comparatifPrix.comparatifPrix.repository;

import fr.comparatifPrix.comparatifPrix.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Integer> {
}
