package fr.comparatifPrix.comparatifPrix.repository;

import org.springframework.stereotype.Repository;


    @Repository
    public interface CustomRelevePrixRepository {
        public Double getPrixMoyen(int idProduit);

}
