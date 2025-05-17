package org.baeldung.persistence.model.hebergement;


import javax.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
public class Hotel extends Hebergement {

    private int nombreEtoiles;
    private boolean piscine;
    private boolean wifi;
}
