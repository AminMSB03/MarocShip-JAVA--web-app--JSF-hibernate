package com.example.shipping.Beans;


import com.example.shipping.Dao.Villes.VillesDaoImpl;
import com.example.shipping.Dao.livraison.LivraisonDaoImpl;
import com.example.shipping.Entities.Livraison;
import com.example.shipping.Entities.Villes;
import com.example.shipping.business.Manager.ManagerBusImpl;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
@RequestScoped
@Named("manager")
public class Manager implements Serializable {
    private long id;

    private List<Villes> villeslist;

    private List<Livraison> livraisons;

    // command infos
    private String date;
    private String endCity;
    private double poids;
    private double distance;
    private String transport;


    public void setLivraisons() {
        LivraisonDaoImpl livraisonDao = new LivraisonDaoImpl();
        this.livraisons = livraisonDao.findAll();
    }

    public Manager() {
        setName();
        setVilleslist();
        setLivraisons();
    }

    public void setVilleslist() {
        VillesDaoImpl villesDao = new VillesDaoImpl();
        this.villeslist = villesDao.findAll();
    }



    public void setName() {
        FacesContext context = FacesContext.getCurrentInstance();
        this.id = (Long) context.getExternalContext().getSessionMap().get("manager");
    }

    public String addLivrason(){
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(this.endCity);

        this.villeslist.forEach(el->{
            if(el.getName().equals(this.endCity))
                this.distance=el.getDistance();
        });

        System.out.println(this.date);
        System.out.println(this.id);
        System.out.println(this.poids);
        System.out.println(this.distance);
        System.out.println(this.transport);


        ManagerBusImpl managerBus = new ManagerBusImpl();
        managerBus.addLivraison(this.id,this.endCity,this.date,this.poids,this.id,this.distance,this.transport);
        return "homeManager";
    }

}
