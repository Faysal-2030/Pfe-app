package org.baeldung.web.model;

import javax.persistence.*;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String arrivalDate;
    private String departureDate;
    private String roomType;
    private int nights;
    private int adults;
    private int children;
    private String paymentType;
    private double totalCost;
    private String status; // New field to track payment status

    // Getters and setters
    // ...
}
