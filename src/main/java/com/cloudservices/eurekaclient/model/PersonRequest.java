package com.cloudservices.eurekaclient.model;

public class PersonRequest {

    private String name;
    private String email;

    public PersonRequest(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public PersonRequest(){

    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
