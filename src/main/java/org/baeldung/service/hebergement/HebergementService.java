package org.baeldung.service.hebergement;

import org.baeldung.persistence.model.hebergement.Hebergement;
import org.baeldung.persistence.model.hebergement.HebergementType;
import org.baeldung.persistence.repository.HebergementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HebergementService {

    private final HebergementRepository hebergementRepository;

    public HebergementService(HebergementRepository hebergementRepository) {
        this.hebergementRepository = hebergementRepository;
    }

    /**
     * Récupère tous les hébergements.
     */
    public List<Hebergement> getAll() {
        return hebergementRepository.findAll();
    }

    /**
     * Récupère les hébergements filtrés par type (enum).
     */
    public List<Hebergement> getByType(String type) {
        return hebergementRepository.findByType(type);
    }

    /**
     * Récupère les hébergements selon le nom du type (String).
     * Si le type est invalide ou null, retourne tous les hébergements.
     */
    public List<Hebergement> getByTypeName(String typeName) {
        if (typeName == null || typeName.trim().isEmpty()) {
            return hebergementRepository.findAll();
        }


        try {
            HebergementType type = HebergementType.valueOf(typeName.toUpperCase());
            return hebergementRepository.findByType(type);
        } catch (IllegalArgumentException ex) {
            // Type inconnu → on retourne tous les hébergements
            return hebergementRepository.findAll();
        }
    }
}
