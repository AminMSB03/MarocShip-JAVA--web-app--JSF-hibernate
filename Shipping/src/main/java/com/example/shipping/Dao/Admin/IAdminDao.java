package com.example.shipping.Dao.Admin;


import com.example.shipping.Entities.Admin;

public interface IAdminDao {

    public Admin getAdminByEmail(String email);

}