package org.baeldung.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.baeldung.persistence.model.hebergement.MaisonHote;

@Repository
public interface MaisonHoteRepository extends JpaRepository<MaisonHote, Long> {

    // Recherche par petit déjeuner inclus
    List<MaisonHote> findByPetitDejeunerInclus(boolean petitDejeunerInclus);

    // Recherche par accueil famille
    List<MaisonHote> findByAccueilFamille(boolean accueilFamille);
}
