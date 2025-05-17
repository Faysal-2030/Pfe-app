package org.baeldung.web.controller.projet.superAdmin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/SuperAdmin")
public class HotelController {

    @GetMapping("/db-vendor-hotels")
    public String getAllHotels(Model model) {
        model.addAttribute("hotels");
        return "SuperAdmin/db-vendor-hotels";
    }
    @GetMapping("/db-vendor-add-hotel")
    public String showAddHotelForm(Model model) {
        // Add any necessary attributes to the model
        return "SuperAdmin/db-vendor-add-hotel";
    }
    @GetMapping("/db-vendor-news")
    public String showNewsForm(Model model) {
        // Add any necessary attributes to the model
        return "SuperAdmin/db-vendor-news";
    }
    @GetMapping("/db-add-news")
    public String showAddNewsForm(Model model) {
        // Add any necessary attributes to the model
        return "SuperAdmin/db-add-news";
    }
}