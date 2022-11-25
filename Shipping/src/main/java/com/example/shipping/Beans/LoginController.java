package com.example.shipping.Beans;

import com.example.shipping.Entities.User;
import com.example.shipping.business.User.IUserBus;
import com.example.shipping.business.User.UserBusImp;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

@Named("loginController")
@SessionScoped
@Data
public class LoginController implements Serializable {
    private String email;
    private String password;
    private String role;

    public String getRole() {
        return role;
    }

    public LoginController() {
         this.userBusImp = new UserBusImp();
    }

    public void setRole(String role) {
        this.role = role;
    }

    private IUserBus userBusImp;

    @NotNull
    @Size(min=3, max=25)
    public String getEmail() { return email; }
    public void setEmail(String username) { this.email = username; }

    @NotNull @Size(min=6, max=20)
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password;}

    public String login(){
        User user = this.userBusImp.login(this.role,this.email,this.password);

        FacesContext context = FacesContext.getCurrentInstance();
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.println(user);
        System.out.println(this.role);

        if (user != null) {
            switch (this.role){
                case "admin":
                    context.getExternalContext().getSessionMap().put("admin", Long.valueOf(user.getId()));
                    return "adminHome";
                case "chauffeur":
                    context.getExternalContext().getSessionMap().put("chauffeur", Long.valueOf(user.getId()));
                    return "chauffeurHome";
                case "manager":
                    context.getExternalContext().getSessionMap().put("manager", Long.valueOf(user.getId()));
                    return "managerHome";
            }
        } else {
            context.addMessage(null, new FacesMessage("Unknown login, try again"));
            email = null;
            password = null;
            role = null ;
            return "index";
        }
        return "index";
    }
}