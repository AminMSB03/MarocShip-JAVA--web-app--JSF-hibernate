package com.example.shipping.Dao.Villes;

import com.example.shipping.Dao.BaseDao;
import com.example.shipping.Entities.Villes;

public class VillesDaoImpl extends BaseDao<Villes> implements IVillesDao {

    public VillesDaoImpl() {
        super(Villes.class);
    }
}
