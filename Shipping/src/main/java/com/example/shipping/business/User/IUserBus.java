package com.example.shipping.business.User;

import com.example.shipping.Entities.User;

public interface IUserBus {
    User login(String role, String email, String password);

    String Logout();

}
