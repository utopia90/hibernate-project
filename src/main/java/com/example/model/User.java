package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String dni;

    @Column(name="is_active")
    private Boolean isActive;

    @Column(name="birthday_date")
    private String birthDate;

    @OneToMany(mappedBy = "user",orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Task> tasks = new ArrayList<>();

    @OneToOne(mappedBy = "user",orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonIgnore
    private BillingInfo billingInfo;

    public User() {
    }

    public User(String name, String surname, String dni, Boolean isActive, String birthDate) {
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.isActive = isActive;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public BillingInfo getBillingInfo() {
        return billingInfo;
    }

    public void setBillingInfo(BillingInfo billingInfo) {
        this.billingInfo = billingInfo;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dni='" + dni + '\'' +
                ", isActive=" + isActive +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }
}
