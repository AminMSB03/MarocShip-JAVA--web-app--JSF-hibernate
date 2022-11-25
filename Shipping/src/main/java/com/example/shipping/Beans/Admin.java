package com.example.shipping.Beans;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import lombok.Data;

import java.io.Serializable;


@Data
@SessionScoped
@Named("user")
public class Admin implements Serializable {
    private long name;

    public Admin() {
        setName();
    }

    public void setName() {
        FacesContext context = FacesContext.getCurrentInstance();
        this.name = (Long) context.getExternalContext().getSessionMap().get("admin");
    }
}
