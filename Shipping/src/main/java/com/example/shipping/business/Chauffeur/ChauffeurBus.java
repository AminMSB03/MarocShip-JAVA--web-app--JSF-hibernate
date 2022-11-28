package com.example.shipping.business.Chauffeur;

import com.example.shipping.Dao.Chauffeur.ChauffeurDaoImpl;
import com.example.shipping.Dao.livraison.LivraisonDaoImpl;
import com.example.shipping.Entities.Chauffeur;
import com.example.shipping.Entities.Livraison;

import java.util.List;
import java.util.stream.Collectors;

public class ChauffeurBus implements IChauffeurBus{
    @Override
    public List<Livraison> getNewLiv(Long id) {
        ChauffeurDaoImpl chauffeurDao = new ChauffeurDaoImpl();
        Chauffeur chauffeur = chauffeurDao.findOne(id);

        LivraisonDaoImpl livraisonDao = new LivraisonDaoImpl();
        List<Livraison> livraisons = livraisonDao.getNewLiv();


        List<Livraison> livraisonList = livraisons.stream().filter(el->{
            return el.getTransportType().equals(chauffeur.getVehicule().getType());
        }).collect(Collectors.toList());

        return livraisonList;
    }

    @Override
    public void takeLiv(Long livId, Long chaufId) {
        ChauffeurDaoImpl chauffeurDao = new ChauffeurDaoImpl();
        Chauffeur chauffeur = chauffeurDao.findOne(chaufId);

        LivraisonDaoImpl livraisonDao = new LivraisonDaoImpl();
        Livraison livraison = livraisonDao.findOne(livId);
        livraison.setVehicule(chauffeur.getVehicule());
    }
}
