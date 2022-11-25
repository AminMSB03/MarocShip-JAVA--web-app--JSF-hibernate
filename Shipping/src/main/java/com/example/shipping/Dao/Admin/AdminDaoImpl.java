package com.example.shipping.Dao.Admin;

import com.example.shipping.Dao.BaseDao;
import com.example.shipping.Entities.Admin;

public class AdminDaoImpl extends BaseDao<Admin> implements IAdminDao {
    @Override
    public Admin getAdminByEmail(String email) {
        return null;
    }

    public AdminDaoImpl() {
        super(Admin.class);
    }


}
