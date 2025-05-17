    package org.baeldung.persistence.model.hebergement;

    import lombok.*;

    import java.util.List;

    import javax.persistence.*;

    @Data
    @Entity
    @Table(name = "appartements")
    @NoArgsConstructor
    public class Appartement {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String titre;

        @Column(length = 1000)
        private String description;

        private String adresse;

        private int nombreChambres;

        private int capacite;

        private double prixParNuit;

        private boolean wifi;

        private boolean climatisation;

        private boolean cuisineEquipee;

        private String proprietaireContact;

        @ElementCollection
        @CollectionTable(name = "appartement_photos", joinColumns = @JoinColumn(name = "appartement_id"))
        @Column(name = "photo_url")
        private List<String> photos;

        public void setId(Long id) {
        this.id = id;
        }
    }