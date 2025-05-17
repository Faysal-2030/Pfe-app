package org.baeldung.web.controller.projet.hebAdmin;

import org.baeldung.persistence.model.hebergement.HebergementType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HebergementController {

    @GetMapping("/Hebergement/{type}/list")
    public String afficherListeParType(@PathVariable("type") String type, Model model) {
        HebergementType hebergementType;

        try {
            hebergementType = HebergementType.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            return "redirect:/404"; // Redirection si type invalide
        }

        // Ajout du type au modèle si besoin
        model.addAttribute("type", hebergementType);

        // Passer la liste des types à la vue
        model.addAttribute("typesHebergement", HebergementType.values());

        // Redirection vers la page correspondante
        switch (hebergementType) {
            case HOTEL:
                return "Hebergement/Hotel/all_hotels_grid_masonry";
            case APPARTEMENT:
                return "Hebergement/Appartement/all_appartement_grid_masonry";
            case MAISON_HOTE:
                return "Hebergement/MaisonHote/all_MaisonHote_grid_masonry";
            case RIAD:
                return "Hebergement/Riad/all_Riad_grid_masonry";
            default:
                return "redirect:/404";
        }
    }
}