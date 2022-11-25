package com.example.shipping.Dao.Chauffeur;

import com.example.shipping.Dao.BaseDao;
import com.example.shipping.Entities.Chauffeur;
import com.example.shipping.Entities.Vehicule;

public class ChauffeurDaoImpl extends BaseDao<Chauffeur> implements IChauffeurDao {

    public ChauffeurDaoImpl() {
        super(Chauffeur.class);
    }


}
