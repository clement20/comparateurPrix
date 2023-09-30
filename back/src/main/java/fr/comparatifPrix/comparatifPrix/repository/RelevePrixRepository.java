package fr.comparatifPrix.comparatifPrix.repository;

import fr.comparatifPrix.comparatifPrix.model.RelevePrix;
import fr.comparatifPrix.comparatifPrix.model.RelevePrixID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RelevePrixRepository extends JpaRepository<RelevePrix, RelevePrixID> {
    @Query(value="""
    SELECT AVG(r.prix)
    FROM 
    Produit p join RelevePrix r on p.id=r.produit.id 
    WHERE p.id = ?1 
    AND r.date = (select max(r2.date) FROM RelevePrix r2)
    """
    )
    public Double getPrixMoyenByIdProduit(int idProduit);

    @Query(value="""
    SELECT r
    FROM 
    RelevePrix r  
    WHERE r.produit.id = ?1 
    AND r.date = (select max(r2.date) FROM RelevePrix r2)
    AND r.prix = (select min(r2.prix) FROM RelevePrix r2 where r2.produit.id=?1)
    """
    )
    public List<RelevePrix> getRelevesPrixMoinsCherByIdProduit(int idProduit);

    @Query(value="""
    SELECT r
    FROM 
    RelevePrix r  
    WHERE r.produit.id = ?1 
    AND r.date = (select max(r2.date) FROM RelevePrix r2)
    AND r.prix = (select max(r2.prix) FROM RelevePrix r2 where r2.produit.id=?1)
    """
    )
    public List<RelevePrix> getRelevePrixPlusCherByIdProduit(int idProduit);
}
