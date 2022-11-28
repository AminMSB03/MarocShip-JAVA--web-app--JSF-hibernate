package com.example.shipping.Beans;

import com.example.shipping.Entities.Livraison;
import com.example.shipping.business.Chauffeur.ChauffeurBus;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
@SessionScoped
@Named("chauffeur")
public class Chauffeur implements Serializable {
    private long id;
    private List<Livraison> livraisonList;

    private ChauffeurBus chauffeurBus;

    public void setId() {
        FacesContext context = FacesContext.getCurrentInstance();
        this.id = (Long) context.getExternalContext().getSessionMap().get("chauffeur");
    }

    public Chauffeur() {
        this.setId();
        this.setLivraisonList();
        this.chauffeurBus = new ChauffeurBus();
    }

    public void setLivraisonList() {
        this.livraisonList = this.chauffeurBus.getNewLiv(this.id);
    }

    public void takeLiv(Long curLivId){
        this.chauffeurBus.takeLiv(curLivId,this.id);
    }

}
