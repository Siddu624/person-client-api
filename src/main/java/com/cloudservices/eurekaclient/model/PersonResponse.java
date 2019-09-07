package com.cloudservices.eurekaclient.model;

public class PersonResponse {
    private int personId;
    private String name;
    private String email;

    public PersonResponse(String name, String email) {
        this.name = name;
        this.email = email;
    }
    public PersonResponse(){

    }
    public int getPersonId() {
        return personId;

    }
    public String getName() {
        return name;
    }
    public void setPersonId(int personId) {
        this.personId = personId;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;

    }
}
