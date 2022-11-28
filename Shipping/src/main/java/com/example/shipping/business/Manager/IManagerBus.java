package com.example.shipping.business.Manager;

public interface IManagerBus {
    void addLivraison(Long idManager,String cityEnd,String startDate, double poids,Long managerId,double distance,String transport);
}
