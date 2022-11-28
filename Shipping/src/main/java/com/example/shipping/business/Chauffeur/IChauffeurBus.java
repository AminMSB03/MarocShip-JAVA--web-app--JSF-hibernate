package com.example.shipping.business.Chauffeur;

import com.example.shipping.Entities.Livraison;

import java.util.List;

public interface IChauffeurBus {

    List<Livraison> getNewLiv(Long id);

    void takeLiv(Long livId, Long chaufId);
}
