package com.rugbyplayers.rugbyplayers;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RugbyPlayer {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    private String name;
    private String lastName;
    private String position;
    private int age;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "RugbyPlayer [id=" + id + ", Last Name= " + lastName + ", Name =" + name + ", Position= " + position
                + ", Age= " + age + "]";

    }
}