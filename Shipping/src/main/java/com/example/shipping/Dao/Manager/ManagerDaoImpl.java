package com.example.shipping.Dao.Manager;

import com.example.shipping.Dao.BaseDao;
import com.example.shipping.Entities.Manager;

import java.util.List;
import java.util.Optional;

public class ManagerDaoImpl extends BaseDao<Manager> implements IManagerDao {

    public ManagerDaoImpl() {
        super(Manager.class);
    }

    @Override
    public Manager getAdminByEmail(String email) {
        return null;
    }

}
