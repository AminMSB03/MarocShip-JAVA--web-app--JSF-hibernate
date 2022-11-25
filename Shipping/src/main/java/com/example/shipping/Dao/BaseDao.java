package com.example.shipping.Dao;


import com.example.shipping.Entities.User;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;

import java.io.Serializable;
import java.util.List;

public abstract class BaseDao<T extends Serializable> {

    protected EntityManager entityManager;

    protected Class<T> clazz;

    protected void setClazz(Class<T> clazz){
        this.clazz = clazz;
    }

    public BaseDao(Class<T> clazz) {
        // Create Entity manager factory object
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        // Create Entity manager object
        this.entityManager = entityManagerFactory.createEntityManager();
        this.setClazz(clazz);
    }

    public void save(T object) {
        // Create a transaction
        EntityTransaction transaction = this.entityManager.getTransaction();
        try{
            transaction.begin();
            this.entityManager.persist(object);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
    }

    public List<T> findAll() {
        return this.entityManager.createQuery("from "+this.clazz.getName()).getResultList();
    }
    public T findOne(long id) {
        return (T) this.entityManager.find(this.clazz,id);
    }

    public void update(final T object) {
        EntityTransaction transaction = this.entityManager.getTransaction();
        try{
            transaction.begin();
            this.entityManager.merge(object);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
    }

    public void deleteById(long entityId) {
        final T entity = this.findOne(entityId);
        this.entityManager.remove(entity);
    }


    public User findUser(String email, String password){
        User user = (User) this.entityManager.createQuery("from "+this.clazz.getSimpleName()+" u where email=:email and password=:password")
        .setParameter("email",email)
        .setParameter("password",password)
        .getSingleResult();
        return user;
    }


}
