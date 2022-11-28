package com.example.shipping.Dao.livraison;

import com.example.shipping.Dao.BaseDao;
import com.example.shipping.Entities.Admin;
import com.example.shipping.Entities.Livraison;
import com.example.shipping.Entities.User;

import java.util.List;

public class LivraisonDaoImpl extends BaseDao<Livraison> implements ILivraisonDao {


    public LivraisonDaoImpl() {
        super(Livraison.class);
    }


    @Override
    public List<Livraison> getNewLiv() {
        List<Livraison> livraisons = this.entityManager.createQuery("from "+this.clazz.getSimpleName()+" u where status=:status")
                .setParameter("status",0)
                .getResultList();
        return livraisons;
    }
}
