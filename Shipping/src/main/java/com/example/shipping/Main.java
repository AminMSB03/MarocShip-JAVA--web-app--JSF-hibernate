package com.example.shipping;

import com.example.shipping.Dao.Manager.ManagerDaoImpl;
import com.example.shipping.Entities.Manager;

public class Main {
    public static void main(String[] args) {
        ManagerDaoImpl managerDao = new ManagerDaoImpl();
        Manager manager =  new Manager();
        manager.setEmail("tes@test.com");
        manager.setLogin("amineMSB");
        manager.setPassword("amine1234");
        managerDao.save(manager);
    }
}
