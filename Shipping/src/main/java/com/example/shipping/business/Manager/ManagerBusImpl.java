package com.example.shipping.business.Manager;

import com.example.shipping.Dao.Chauffeur.ChauffeurDaoImpl;
import com.example.shipping.Dao.Vehicule.VehiculeDaoImpl;
import com.example.shipping.Dao.livraison.LivraisonDaoImpl;
import com.example.shipping.Entities.Chauffeur;
import com.example.shipping.Entities.Livraison;
import com.example.shipping.Entities.Vehicule;
import com.example.shipping.helpers.HashingPassword;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public void addChauffeur(String email, String password, Long Id) {
        VehiculeDaoImpl vehiculeDao = new VehiculeDaoImpl();
        Vehicule vehicule = vehiculeDao.findOne(Id);

        ChauffeurDaoImpl chauffeurDao = new ChauffeurDaoImpl();
        Chauffeur chauffeur = new  Chauffeur();
        chauffeur.setEmail(email);
        chauffeur.setPassword(new HashingPassword().hashingPassword(password));
        chauffeur.setVehicule(vehicule);
        chauffeurDao.save(chauffeur);
    }

    @Override
    public List<Vehicule> getFreeVehicule() {
        VehiculeDaoImpl vehiculeDao = new VehiculeDaoImpl();
        List<Vehicule> vehicules = vehiculeDao.findAll();
        List<Vehicule> vehiculeList = vehicules.stream().filter(el->{
            return el.getChauffeur()==null;
        }).collect(Collectors.toList());
        return vehiculeList;
    }


}
