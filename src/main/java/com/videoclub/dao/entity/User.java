package com.videoclub.dao.entity;

import com.videoclub.controller.model.responses.UserResponse;

public class User {

    private Long id;
    private String firstname;
    private String lastname;
    private int age;
    private String address;
    private int phone;
    private String mail;


    public User() {
    }

    public User( String firstname, String lastname, int age, String address, int phone, String mail) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.address = address;
        this.phone = phone;
        this.mail = mail;
    }

    public UserResponse toDto(){
        UserResponse m = new UserResponse();
        m.setId(this.id);
        m.setFirstname(this.firstname);
        m.setLastname(this.lastname);
        m.setAddress(this.address);
        m.setAge(this.age);
        m.setPhone(this.phone);
        m.setMail(this.mail);
        return m;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirtname() {
        return firstname;
    }

    public void setFirstname(String firtname) {
        this.firstname = firtname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
