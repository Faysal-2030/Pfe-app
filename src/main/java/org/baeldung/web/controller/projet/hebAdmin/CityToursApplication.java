package org.baeldung.web.controller.projet.hebAdmin;

import org.baeldung.persistence.model.hebergement.Hebergement;
import org.baeldung.persistence.model.hebergement.HebergementType;
import org.baeldung.persistence.model.hebergement.Hotel;
import org.baeldung.persistence.repository.HebergementRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

public class CityToursApplication {
    
    @Bean
public CommandLineRunner loadData(HebergementRepository repo) {
    return (args) -> {
        Hotel hotel = new Hotel();
        hotel.setNom("Hotel Atlas");
        hotel.setType(HebergementType.HOTEL);
        hotel.setDescription("Un superbe hôtel 5 étoiles.");
        hotel.setImagePrincipale("hotel_atlas.jpg");
        hotel.setPrixParNuit(150.0);
        hotel.setAdresse("Marrakech");
        hotel.setCapacite(2);
        repo.save(hotel);
    };
}
            @Bean
CommandLineRunner initData(HebergementRepository repo) {
    return args -> {
        if (repo.count() == 0) {
            Hebergement h = new Hebergement();
            h.setNom("Chambre Deluxe");
            h.setPrixParNuit(120.00);
            h.setImagePrincipale("/img/chambres/deluxe.jpg");
            h.setDisponible(true);
            repo.save(h);
        }
    };
}

}
