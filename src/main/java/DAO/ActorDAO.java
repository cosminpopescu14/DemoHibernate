package DAO;

import Entities.Actor;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ActorDAO {

    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    public ActorDAO() {
        this.entityManager = Persistence
                .createEntityManagerFactory("sakila-unit")
                .createEntityManager();;
        this.entityTransaction = this.entityManager.getTransaction();
    }

    public Actor find(int id) {
        return entityManager.find(Actor.class, id);
    }

    public void save(String firstName, String lastName) {
        beginTransaction();
        var actor = new Actor(firstName, lastName);
        entityManager.persist(actor);
        commitTransaction();

    }

    public void update(int id, String firstName, String lastName) {
        beginTransaction();
        var actor = find(id);
        actor.setFirst_name(firstName);
        actor.setLast_name(lastName);
        entityManager.merge(actor);
        commitTransaction();
    }
    public void delete(int id) {
        beginTransaction();
        var actor = find(id);
        entityManager.remove(actor);
        commitTransaction();
    }

    private void commitTransaction() {
        try {
            entityTransaction.commit();
            entityManager.close();
        }
        catch (IllegalStateException e) {
            System.out.println("Error in commiting transaction. Rolling back...");
            rollbackTransaction();
        }
    }

    private void beginTransaction() {
        try {
            entityTransaction.begin();
        }
        catch (IllegalStateException e) {
            System.out.println("Error in instering into db:" + e);
            rollbackTransaction();
        }
    }

    private void rollbackTransaction() {
        try {
            entityTransaction.rollback();
        }
        catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }
}
