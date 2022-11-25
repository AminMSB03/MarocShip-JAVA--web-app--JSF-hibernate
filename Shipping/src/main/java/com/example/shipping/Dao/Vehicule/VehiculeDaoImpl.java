package com.example.shipping.Dao.Vehicule;

import com.example.shipping.Dao.BaseDao;
import com.example.shipping.Entities.Vehicule;

public class VehiculeDaoImpl extends BaseDao<Vehicule> implements IVehiculeDao {

    public VehiculeDaoImpl() {
        super(Vehicule.class);
    }


}
