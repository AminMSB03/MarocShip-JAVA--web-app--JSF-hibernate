package com.example.shipping.Dao.Manager;

import com.example.shipping.Entities.Admin;
import com.example.shipping.Entities.Manager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Optional;

public class ManagerDaoImpl implements IManagerDao {

    private EntityManager entityManager;

    public ManagerDaoImpl() {

        // Create Entity manager factory object
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

        // Create Entity manager object
        this.entityManager = entityManagerFactory.createEntityManager();
    }


    @Override
    public void save(Manager manager) {
        // Create a transaction
        EntityTransaction transaction = this.entityManager.getTransaction();

        // start transaction
        transaction.begin();
        try{
            // register the admin on tha DB
            entityManager.persist(manager);

            // validate the transaction
            transaction.commit();

        }catch (Exception exception){
            // cancel  the transaction in case of transaction
            transaction.rollback();
            exception.printStackTrace();
        }
    }

    @Override
    public List<Manager> findAll() {
        return null;
    }

    @Override
    public Optional<Manager> getAdminByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public Optional<Manager> getAdminById(Long id) {
        return Optional.empty();
    }
}
