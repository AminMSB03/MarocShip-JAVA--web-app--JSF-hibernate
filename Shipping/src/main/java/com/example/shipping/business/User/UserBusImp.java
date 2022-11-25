package com.example.shipping.business.User;

import com.example.shipping.Dao.Admin.AdminDaoImpl;
import com.example.shipping.Dao.Chauffeur.ChauffeurDaoImpl;
import com.example.shipping.Dao.Manager.ManagerDaoImpl;
import com.example.shipping.Entities.Admin;
import com.example.shipping.Entities.Chauffeur;
import com.example.shipping.Entities.Manager;
import com.example.shipping.Entities.User;
import com.example.shipping.helpers.HashingPassword;

public class UserBusImp implements IUserBus{
    @Override
    public User login(String role, String email, String password) {
        String HashedPassword;
        switch (role){
            case "admin":
                AdminDaoImpl adminDao = new AdminDaoImpl();
                HashedPassword = new HashingPassword().hashingPassword(password);
                User admin = adminDao.findUser(email,HashedPassword);
                return admin;
            case "manager":
                ManagerDaoImpl managerDao = new ManagerDaoImpl();
                HashedPassword = new HashingPassword().hashingPassword(password);
                User manager =  managerDao.findUser(email,HashedPassword);
                return manager;
            case "chauffeur":
                ChauffeurDaoImpl chauffeurDao = new ChauffeurDaoImpl();
                HashedPassword = new HashingPassword().hashingPassword(password);
                User chauffeur =  chauffeurDao.findUser(email,HashedPassword);
                return chauffeur;
        }
        return null;
    }

    @Override
    public String Logout() {
        return null;
    }
}
