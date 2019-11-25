package HibernateApp;

import Entities.Actor;

import javax.persistence.Persistence;

public class HibernateMainApp {

    public static void main(String[] args) {

        var entityManager = Persistence
                .createEntityManagerFactory("sakila-unit")
                .createEntityManager();

        var entityTransaction = entityManager.getTransaction();

        var actor = entityManager.find(Actor.class, 6); //finding an actor with specified id

        //persist an actor. the insert is done within transaction
        entityTransaction.begin();
        Actor actor1 = new Actor("Cosmin", "Popescu");
        entityManager.persist(actor1);
        entityTransaction.commit();

        //update an actor


        var s = "\uD81E\uDD70";
        System.out.println(":3");

        System.out.println(actor.getFirst_name() + " " + actor.getLast_name() + s);
        entityManager.close();
    }
}
