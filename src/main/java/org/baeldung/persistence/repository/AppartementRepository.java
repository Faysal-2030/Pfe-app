package org.baeldung.persistence.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.baeldung.persistence.model.hebergement.Appartement;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppartementRepository extends JpaRepository<Appartement, Long> {

    List<Appartement> findByNombreChambres(int nombreChambres);

    List<Appartement> findByCapaciteGreaterThanEqual(int capacite);

    List<Appartement> findByWifiTrue();

    List<Appartement> findByClimatisationTrue();

    List<Appartement> findByPrixParNuitLessThanEqual(double prixMax);

    List<Appartement> findByWifiTrueAndNombreChambres(int nombreChambres);
}