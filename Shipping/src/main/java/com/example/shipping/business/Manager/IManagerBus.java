package com.example.shipping.business.Manager;

import com.example.shipping.Entities.Vehicule;

import java.util.List;

public interface IManagerBus {
    void addLivraison(Long idManager,String cityEnd,String startDate, double poids,Long managerId,double distance,String transport);

    void addChauffeur(String email, String password, Long Id);

    List<Vehicule> getFreeVehicule();
}
