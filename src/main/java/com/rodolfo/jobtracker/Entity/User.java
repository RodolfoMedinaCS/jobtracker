package com.rodolfo.jobtracker.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "_users")
public class User {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String email;
    private String password;

    public User(){}
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }


    //getters
    public long getId(){return id;}
    public String getName(){return name;}
    public String getEmail(){return email;}
    public String getPassword(){return password;}
    //setters
    public void setId(long id){this.id = id;}
    public void setName(String name){this.name = name;}
    public void setEmail(String email){this.name = email;}
    public void setPassword(String password){this.password = password;}

}
