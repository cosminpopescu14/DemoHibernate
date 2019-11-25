package Entities;

import javax.persistence.*;

/*
This class it's a container for data. Entity annotation tells hibernate
to make it persistable
 */

@Entity
@Table(name = "actor")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //how to handle the primary key.
    @Column(name = "actor_id")
    private int actor_id;

    private String first_name;
    private String last_name;

    public Actor(){}

    public Actor(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}
