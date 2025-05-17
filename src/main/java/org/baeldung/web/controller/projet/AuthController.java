package org.baeldung.web.controller.projet;

import org.baeldung.web.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/faysal/")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private JavaMailSender mailSender;

    @GetMapping("/all_hotels_list")
    public String login() {
        return "Hebergement/Hebergement1/all_hotels_listt";
    }

    @PostMapping("/sendConfirmationEmail")
    @ResponseBody
    public String sendConfirmationEmail(@RequestBody Reservation reservation) {
        try {
            sendEmailWithReservationDetails(reservation);
            return "Email sent successfully!";
        } catch (Exception e) {
            logger.error("Error sending email: ", e);
            return "Failed to send email: " + e.getMessage();
        }
    }

    private void sendEmailWithReservationDetails(Reservation reservation) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("reajouanifayssal@gmail.com"); // Replace with the recipient's email
        message.setSubject("Confirmation de Réservation");
        message.setText("Votre réservation a été confirmée avec succès !\n\n" +
                "Détails de la réservation :\n" +
                "Nom: " + reservation.getName() + "\n" +
                "Date d'arrivée: " + reservation.getArrivalDate() + "\n" +
                "Date de départ: " + reservation.getDepartureDate() + "\n" +
                "Type de chambre: " + reservation.getRoomType() + "\n" +
                "Nombre de nuits: " + reservation.getNights() + "\n" +
                "Adultes: " + reservation.getAdults() + "\n" +
                "Enfants: " + reservation.getChildren() + "\n" +
                "Type de paiement: " + reservation.getPaymentType() + "\n" +
                "Coût total: $" + reservation.getTotalCost() + "\n\n" +
                "Merci pour votre réservation !");
        mailSender.send(message);
    }

    private void sendAdminNotification(Reservation reservation) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo("admin@example.com"); // Replace with the admin's email
            message.setSubject("New Reservation Confirmation");
            message.setText("A new reservation has been confirmed:\n\n" +
                    "Name: " + reservation.getName() + "\n" +
                    "Arrival Date: " + reservation.getArrivalDate() + "\n" +
                    "Departure Date: " + reservation.getDepartureDate() + "\n" +
                    "Total Cost: $" + reservation.getTotalCost());
            mailSender.send(message);
        } catch (Exception e) {
            System.err.println("Error sending admin notification: " + e.getMessage());
        }
    }
}