package com.example.shipping.business.Manager;

import com.example.shipping.Dao.livraison.LivraisonDaoImpl;
import com.example.shipping.Entities.Livraison;

public class ManagerBusImpl implements IManagerBus{


    @Override
    public void addLivraison(Long idManager,String cityEnd,String startDate, double poids,Long managerId,double distance,String transport) {

        double tarif ;
        if(poids<=4){
            tarif=poids*40;
        }else{
            tarif=(poids-4)*5+4*40;
        }
        LivraisonDaoImpl livraisonDao = new LivraisonDaoImpl();
        Livraison livraison = new Livraison();
        livraison.setCity_end(cityEnd);
        livraison.setPoids(poids);
        livraison.setTransportType(transport);
        livraison.setTarif(tarif);
        livraisonDao.save(livraison);
    }
}
