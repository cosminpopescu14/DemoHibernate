package HibernateApp;

import DAO.ActorDAO;

public class HibernateMainApp {
    private  static final ActorDAO actorDAO = new ActorDAO();


    public static void main(String[] args) {

        System.out.println(actorDAO.find(6).getFirst_name());


    }
}
