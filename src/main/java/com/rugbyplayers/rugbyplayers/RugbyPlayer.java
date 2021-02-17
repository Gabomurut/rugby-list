package com.rugbyplayers.rugbyplayers;

public class RugbyPlayer {

    private int id;
    private String name;
    private String lastName;
    private String position;
    private int age;

    public RugbyPlayer(int id, String name, String lastName, String position, int age) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.position = position;
        this.age = age;
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