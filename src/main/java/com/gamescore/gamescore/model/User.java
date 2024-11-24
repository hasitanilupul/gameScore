
package com.gamescore.gamescore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQuery(name = "findByName",
query = "select u from User u where u.name = ?1")
public class User {

    @Id
    private int id;

    private String name;

    private String email;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String username) {
        this.name = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(User user) {
        this.name = user.name;
        this.email = user.email;
    }

}