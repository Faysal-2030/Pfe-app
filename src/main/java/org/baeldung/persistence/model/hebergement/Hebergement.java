package org.baeldung.persistence.model.hebergement;

import javax.persistence.*;
import lombok.*;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@Table(name = "hebergement") // <- très important
public abstract class Hebergement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

        @Enumerated(EnumType.STRING)
        private HebergementType type;

    private String nom;
    private String description;
    private String imagePrincipale;
    private double prixParNuit;

    private String adresse;   // si tu l’as ajouté plus tôt
    private int capacite;     

    public String getNom() {
        return nom;
    }

public void setType(HebergementType type) {
    this.type = type;
}
    public HebergementType getType() {
        return type;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePrincipale() {
        return imagePrincipale;
    }

    public void setImagePrincipale(String imagePrincipale) {
        this.imagePrincipale = imagePrincipale;
    }

    public double getPrixParNuit() {
        return prixParNuit;
    }

    public void setPrixParNuit(double prixParNuit) {
        this.prixParNuit = prixParNuit;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }
}
