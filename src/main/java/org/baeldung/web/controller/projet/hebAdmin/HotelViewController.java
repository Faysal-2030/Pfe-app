package org.baeldung.web.controller.projet.hebAdmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hebergement/hotel")
public class HotelViewController {

    @GetMapping("/single_hotel")
    public String showHotelDetails() {
        return "hebergement/hotel/single_hotel";
    }
    @GetMapping("/carte_hotel")
    public String showHotelMap() {
        return "hebergement/hotel/carte_hotel";
    }
    @GetMapping("/all_hotel_list")
    public String showAllHotels() {
        return "hebergement/hotel/all_hotel_list";
    }
    @GetMapping("/payment_hotel")
    public String showHotelPayment() {
        return "hebergement/hotel/payment_hotel";
    }
    @GetMapping("/confirmation_hotel")
    public String showHotelConfirmation() {
        return "hebergement/hotel/confirmation_hotel";
    }
    @GetMapping("/single_hotel_contact")
    public String showHotelContact() {
        return "hebergement/hotel/single_hotel_contact";
    }
    @GetMapping("/single_hotel_working_booking")
    public String showHotelWorkingBooking() {
        return "hebergement/hotel/single_hotel_working_booking";
    }
}
