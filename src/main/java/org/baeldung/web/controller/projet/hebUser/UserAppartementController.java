package org.baeldung.web.controller.projet.hebUser;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.baeldung.persistence.model.hebergement.Appartement;
import org.baeldung.service.hebergement.AppartementService;

@Controller
@RequestMapping("/appartements")
public class UserAppartementController {

    private final AppartementService appartementService;

    public UserAppartementController(AppartementService appartementService) {
        this.appartementService = appartementService;
    }

    @GetMapping("/list")
    public String listAppartements(Model model) {
        List<Appartement> appartements = appartementService.getAllAppartements();
        model.addAttribute("appartements", appartements);
        return "hebergement/appartement/all_appartements_list";
    }

    @GetMapping("/details/{id}")
    public String showDetails(@PathVariable Long id, Model model) {
        Appartement appartement = appartementService.getAppartementById(id).orElse(null);
        model.addAttribute("appartement", appartement);
        return "hebergement/appartement/single_appartements";
    }
}
