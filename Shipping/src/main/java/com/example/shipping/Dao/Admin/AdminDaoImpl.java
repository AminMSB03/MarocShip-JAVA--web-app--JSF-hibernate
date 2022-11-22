package com.example.shipping.Dao.Admin;

import com.example.shipping.Entities.Admin;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Optional;

public class AdminDaoImpl implements IAdminDao {

    private EntityManager entityManager;

    public AdminDaoImpl() {

        // Create Entity manager factory object
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

        // Create Entity manager object
        this.entityManager = entityManagerFactory.createEntityManager();
    }


    @Override
    public void save(Admin admin) {
        // Create a transaction
        EntityTransaction transaction = this.entityManager.getTransaction();

        // start transaction
        transaction.begin();
        try{
            // register the admin on tha DB
            entityManager.persist(admin);

            // validate the transaction
            transaction.commit();

        }catch (Exception exception){
            // cancel  the transaction in case of transaction
            transaction.rollback();
            exception.printStackTrace();
        }
    }

    @Override
    public List<Admin> findAll() {
        return null;
    }

    @Override
    public Optional<Admin> getAdminByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public Optional<Admin> getAdminById(Long id) {
        return Optional.empty();
    }
}
