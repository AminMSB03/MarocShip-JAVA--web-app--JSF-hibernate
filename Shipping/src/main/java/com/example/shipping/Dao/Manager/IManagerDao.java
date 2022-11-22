package com.example.shipping.Dao.Manager;


import com.example.shipping.Entities.Manager;

import java.util.List;
import java.util.Optional;

public interface IManagerDao {

    public void save(Manager manager);
    public List<Manager> findAll();

    public Optional<Manager> getAdminByEmail(String email);

    public Optional<Manager> getAdminById(Long id);


}