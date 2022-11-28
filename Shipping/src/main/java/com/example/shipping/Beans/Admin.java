package com.example.shipping.Beans;

import com.example.shipping.business.Admin.AdminBusImp;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import lombok.Data;

import java.io.Serializable;


@Data
@SessionScoped
@Named("admin")
public class Admin implements Serializable {
    private long name;
    private String managerEmail;
    private String managerPassword;


    public Admin() {
        setName();
    }

    public void setName() {
        FacesContext context = FacesContext.getCurrentInstance();
        this.name = (Long) context.getExternalContext().getSessionMap().get("admin");
    }

    public String addManager(){
        AdminBusImp adminBusImp = new AdminBusImp();
        adminBusImp.addManager(this.managerEmail,this.managerPassword);
        return "homeAdin";
    }

}
