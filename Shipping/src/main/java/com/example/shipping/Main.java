package com.example.shipping;

import com.example.shipping.Dao.Admin.AdminDaoImpl;
import com.example.shipping.Entities.Admin;
import com.example.shipping.helpers.HashingPassword;


public class Main {
    public static void main(String[] args) {
        AdminDaoImpl adminDao = new AdminDaoImpl();
        String password = new HashingPassword().hashingPassword("admin123");
        Admin admin = (Admin) adminDao.findUser("admin@ship.com",password);
        System.out.println(admin);
    }
}
