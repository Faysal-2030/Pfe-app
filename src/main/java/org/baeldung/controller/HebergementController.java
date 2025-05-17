package org.baeldung.controller;

import org.baeldung.persistence.model.hebergement.Hebergement;
import org.baeldung.persistence.repository.HebergementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller("hebergementAdminController") 
@RequestMapping("/Hebergement")
public class HebergementController {

    @Autowired
    private HebergementRepository hebergementRepository;

    @GetMapping("/Hebergement/list")
    public String listHebergements(@RequestParam(required = false) String type, Model model) {
        List<Hebergement> hebergements;

        System.out.println("Paramètre type reçu : " + type);

        if (type == null || type.trim().isEmpty()) {
            hebergements = hebergementRepository.findAll();
        } else {
            hebergements = hebergementRepository.findByType(type.trim());
            // Si aucun résultat, fallback sur tous les hébergements
            if (hebergements == null || hebergements.isEmpty()) {
                System.out.println("Aucun hébergement trouvé pour le type '" + type + "', fallback sur tous.");
                hebergements = hebergementRepository.findAll();
            }
        }

        System.out.println("Nombre d'hébergements trouvés : " + hebergements.size());
        for (Hebergement hebergement : hebergements) {
            System.out.println("Hébergement : " + hebergement.getNom() + ", Type : " + hebergement.getType());
        }

        model.addAttribute("hebergements", hebergements);

        return "Hebergement/Tous_Hebergement/cart_Hebergement";
    }

    @GetMapping("/faysal")
public String afficherPanier(Model model) {
    List<Hebergement> hebergements = hebergementRepository.findAll(); // Ou une méthode personnalisée
    model.addAttribute("hebergements", hebergements);
    return "hebergement/Tous_Hebergement/cart_Hebergement";
}


}