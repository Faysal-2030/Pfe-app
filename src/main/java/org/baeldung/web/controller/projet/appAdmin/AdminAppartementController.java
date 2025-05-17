package org.baeldung.web.controller.projet.appAdmin;

import org.baeldung.persistence.model.hebergement.Appartement;
import org.baeldung.service.hebergement.AppartementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/appartements")
public class AdminAppartementController {

    private final AppartementService appartementService;

    public AdminAppartementController(AppartementService appartementService) {
        this.appartementService = appartementService;
    }

    @GetMapping("/list")
    public String listAppartements(Model model) {
        List<Appartement> appartements = appartementService.getAllAppartements();
        model.addAttribute("appartements", appartements);
        return "admin/appartements/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("appartement", new Appartement());
        return "admin/appartements/create";
    }

    @PostMapping("/save")
    public String saveAppartement(@ModelAttribute Appartement appartement) {
        appartementService.saveAppartement(appartement);
        return "redirect:/admin/appartements/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Appartement appartement = appartementService.getAppartementById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id invalide : " + id));
        model.addAttribute("appartement", appartement);
        return "admin/appartements/edit";
    }

    @PostMapping("/update/{id}")
    public String updateAppartement(@PathVariable Long id, @ModelAttribute Appartement appartement) {
        appartement.setId(id);
        appartementService.saveAppartement(appartement);
        return "redirect:/admin/appartements/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteAppartement(@PathVariable Long id) {
        appartementService.deleteAppartement(id);
        return "redirect:/admin/appartements/list";
    }
}