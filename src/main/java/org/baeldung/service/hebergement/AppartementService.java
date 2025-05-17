package org.baeldung.service.hebergement;

import org.baeldung.persistence.model.hebergement.Appartement;
import org.baeldung.persistence.repository.AppartementRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppartementService {

    private final AppartementRepository appartementRepository;

    public AppartementService(AppartementRepository appartementRepository) {
        this.appartementRepository = appartementRepository;
    }

    public List<Appartement> getAllAppartements() {
        return appartementRepository.findAll();
    }

    public Optional<Appartement> getAppartementById(Long id) {
        return appartementRepository.findById(id);
    }

    public List<Appartement> findByNombreChambres(int nombreChambres) {
        return appartementRepository.findByNombreChambres(nombreChambres);
    }

    public List<Appartement> findByCapaciteMin(int capacite) {
        return appartementRepository.findByCapaciteGreaterThanEqual(capacite);
    }

    public Appartement saveAppartement(Appartement appartement) {
        return appartementRepository.save(appartement);
    }

    public void deleteAppartement(Long id) {
        appartementRepository.deleteById(id);
    }
}
