package org.baeldung.persistence.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import org.baeldung.persistence.model.hebergement.*;

@Repository
public interface HebergementRepository extends JpaRepository<Hebergement, Long> {

    // Recherche par type d'hébergement
    List<Hebergement> findByType(HebergementType type);
    List<Hebergement> findByType(String type);

    // Recherche par nom d'hébergement (partiel, insensible à la casse)
    List<Hebergement> findByNomContainingIgnoreCase(String nom);

    // Recherche par prix inférieur ou égal à un certain montant
    List<Hebergement> findByPrixParNuitLessThanEqual(double prixMax);

    // Recherche par capacité minimale
    List<Hebergement> findByCapaciteGreaterThanEqual(int capaciteMin);

    // Recherche par adresse (partiel, insensible à la casse)
    List<Hebergement> findByAdresseContainingIgnoreCase(String adresse);

    // Recherche par nom et type
    Optional<Hebergement> findByNomAndType(String nom, HebergementType type);

    // Recherche avec pagination
    Page<Hebergement> findAll(Pageable pageable);

    // Recherche par type et prix
    List<Hebergement> findByTypeAndPrixParNuitLessThanEqual(HebergementType type, double prixMax);

    // Recherche par type et capacité
    List<Hebergement> findByTypeAndCapaciteGreaterThanEqual(HebergementType type, int capaciteMin);

}
