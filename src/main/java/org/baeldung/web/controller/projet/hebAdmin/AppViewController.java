package org.baeldung.web.controller.projet.hebAdmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hebergement/")
public class AppViewController {
    
    @GetMapping("/all_hebergement_list")
    public String showappartementsDetails() {
        return "hebergement/Tous_Hebergement/all_Hebergement_list";
    }
    @GetMapping("/system/checkout")
    public String showappartements_system() {
        return "hebergement/system/checkout";
    }
    @GetMapping("/cart_Hebergement")
    public String showappartementsMap() {
        return "hebergement/Tous_Hebergement/cart_Hebergement";
    }
    @GetMapping("/all_appartements_list")
    public String showAllappartements() {
        return "hebergement/appartement/all_appartements_list";
    }
    @GetMapping("/payment_appartements")
    public String showappartementsPayment() {
        return "hebergement/appartement/payment_appartements";
    }
    @GetMapping("/confirmation_Hebergement")
    public String showappartementsConfirmation() {
        return "hebergement/Tous_Hebergement/confirmation_Hebergement";
    }
    @GetMapping("/single_Hebergement_contact")
    public String showappartementsContact() {
        return "hebergement/Tous_Hebergement/single_Hebergement_contact";
    }
    @GetMapping("/single_appartements_working_booking")
    public String showappartementsWorkingBooking() {
        return "hebergement/appartement/single_appartements_working_booking";
    }
    @GetMapping("/all-hotels")
    public String getAllHotels() {
        return "Hebergement/Hebergement1/all_hotels_list";
    }
}