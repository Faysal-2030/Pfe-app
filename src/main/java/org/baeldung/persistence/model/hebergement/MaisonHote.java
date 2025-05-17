package org.baeldung.persistence.model.hebergement;

import javax.persistence.Entity;
import lombok.*;

@Entity
@NoArgsConstructor
public class MaisonHote extends Hebergement {

    private boolean petitDejeunerInclus;
    private boolean accueilFamille;
}

