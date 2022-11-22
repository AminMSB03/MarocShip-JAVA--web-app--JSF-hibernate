package com.example.shipping.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Chauffeur extends  User {

    private double kilometrage;
    private double prime;

    @OneToOne(fetch = FetchType.EAGER)
    private Vehicule vehicule;

}

