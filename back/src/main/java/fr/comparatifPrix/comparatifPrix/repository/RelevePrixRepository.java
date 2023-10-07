package fr.comparatifPrix.comparatifPrix.repository;

import fr.comparatifPrix.comparatifPrix.model.RelevePrix;
import fr.comparatifPrix.comparatifPrix.model.RelevePrixID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface RelevePrixRepository extends JpaRepository<RelevePrix, RelevePrixID> {
    @Query(value="""
    SELECT AVG(r.prix)
    FROM 
    Produit p join RelevePrix r on p.id=r.produit.id 
    WHERE p.id = ?1 
    AND r.date = ?2
    """
    )
    public Double getPrixMoyenByIdProduit(int idProduit, Date date);

    @Query(value="""
    SELECT r
    FROM 
    RelevePrix r  
    WHERE r.produit.id = ?1 
    and r.prix= ?2
    AND r.date = ?3
    """
    )
    public List<RelevePrix> getRelevesPrixByIdProduitMontantDate(int idProduit, Double montant, Date date);

    @Query(value="""
    SELECT max(r.prix)
    FROM 
    RelevePrix r  
    WHERE r.produit.id = ?1 
    AND r.date = ?2
    """
    )
    public Double getMaxMontantByIdProduitDate(int idProduit, Date date);

    @Query(value="""
    SELECT min(r.prix)
    FROM 
    RelevePrix r  
    WHERE r.produit.id = ?1 
    AND r.date = ?2
    """
    )
    public Double getMinMontantByIdProduitDate(int idProduit, Date date);

    @Query(value="""
    SELECT r.prix
    FROM 
    RelevePrix r  
    WHERE r.produit.id = ?1 
    AND r.date = (select max(r2.date) FROM RelevePrix r2)
    AND r.enseigne.id= ?2
    """
    )
    public Double getMontantParProduitParEnseigne(int idProduit, int idEnseigne);

    @Query(value="""
    SELECT avg(r.prix)
    FROM 
    RelevePrix r  
    WHERE r.produit.id = ?1 
    AND r.date = (select max(r2.date) FROM RelevePrix r2)
    AND r.enseigne.id != ?2
    """
    )
    public Double getMoyenneAutresEnseignesParProduit(int idProduit, int idEnseigne);

    @Query(value="""
    SELECT max(r.date)
    FROM 
    RelevePrix r  
    """
    )
    public Date getMaxDate();
}
