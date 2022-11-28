package com.example.shipping.business.Admin;

import com.example.shipping.Dao.Manager.ManagerDaoImpl;
import com.example.shipping.Entities.Manager;
import com.example.shipping.helpers.HashingPassword;


public class AdminBusImp implements IAdminBus{
    @Override
    public void addManager(String email, String password) {

        ManagerDaoImpl managerDao = new ManagerDaoImpl();
        Manager manager = new Manager();
        manager.setEmail(email);
        manager.setPassword(new HashingPassword().hashingPassword(password));

        managerDao.save(manager);
    }
}
