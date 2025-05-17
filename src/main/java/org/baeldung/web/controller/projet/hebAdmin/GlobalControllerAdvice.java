package org.baeldung.web.controller.projet.hebAdmin;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

import org.baeldung.persistence.model.hebergement.HebergementType;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ModelAttribute
    public void addHebergementData(Model model) {
        // Liste des types
        HebergementType[] types = HebergementType.values();
        model.addAttribute("typesHebergement", types);

        // Liste des villes (fixes ou dynamiques si tu veux plus tard)
        List<String> villes = Arrays.asList("MARRAKECH", "FES", "AGADIR");
        model.addAttribute("villes", villes);

        // Ou structure type -> villes (si tu veux afficher chaque type avec ses villes)
        Map<HebergementType, List<String>> typeVilles = new LinkedHashMap<>();
        for (HebergementType type : types) {
            typeVilles.put(type, villes);
        }
        model.addAttribute("typeVilles", typeVilles);
    }
}
