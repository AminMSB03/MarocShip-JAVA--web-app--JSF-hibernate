package com.example.shipping;

import com.example.shipping.Dao.Admin.AdminDaoImpl;
import com.example.shipping.Dao.Villes.VillesDaoImpl;
import com.example.shipping.Dao.livraison.LivraisonDaoImpl;
import com.example.shipping.Entities.Admin;
import com.example.shipping.helpers.HashingPassword;


public class Main {
    public static void main(String[] args) {
        //AdminBusImp adminBusImp = new AdminBusImp();
        //adminBusImp.addManager("manager@ship.com","manager123");

        AdminDaoImpl adminDao = new AdminDaoImpl();
        Admin admin = new Admin();
        admin.setLogin("adminMSB");
        admin.setEmail("admin@ship.com");
        admin.setPassword(new HashingPassword().hashingPassword("admin123"));
        adminDao.save(admin);


    }
}
