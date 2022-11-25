package com.example.shipping.Dao.Manager;


import com.example.shipping.Entities.Manager;

import java.util.List;
import java.util.Optional;

public interface IManagerDao {

    public Manager getAdminByEmail(String email);

}