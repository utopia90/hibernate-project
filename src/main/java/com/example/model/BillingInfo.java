package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="billing_info")
public class BillingInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String creditCard;
    private String bankName;
    private String paymentMethod;

    @JsonIgnore
    @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user")
    private User user;

    public BillingInfo() {
    }

    public BillingInfo(String creditCard, String bankName, String paymentMethod) {
        this.creditCard = creditCard;
        this.bankName = bankName;
        this.paymentMethod = paymentMethod;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "BillingInfo{" +
                "id=" + id +
                ", creditCard='" + creditCard + '\'' +
                ", bankName='" + bankName + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", user=" + user +
                '}';
    }
}
