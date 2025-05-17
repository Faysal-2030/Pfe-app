package org.baeldung.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.baeldung.persistence.model.hebergement.Riad;

@Repository
public interface RiadRepository extends JpaRepository<Riad, Long> {

    // Recherche par patio (riads avec un patio)
    List<Riad> findByPatio(boolean patio);

    // Recherche par présence de hammam
    List<Riad> findByHammam(boolean hammam);
}
