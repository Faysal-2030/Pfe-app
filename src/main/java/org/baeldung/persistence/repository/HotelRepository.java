package org.baeldung.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.baeldung.persistence.model.hebergement.HebergementType;
import org.baeldung.persistence.model.hebergement.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    // Recherche par nombre d'étoiles
    List<Hotel> findByNombreEtoiles(int nombreEtoiles);

    // Recherche par présence de piscine
    List<Hotel> findByPiscine(boolean piscine);

    // Recherche par accès wifi
    List<Hotel> findByWifi(boolean wifi);

    // Recherche par type (pouvant être un sous-type d'Hebergement)
    List<Hotel> findByType(HebergementType type);
}
