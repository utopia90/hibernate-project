package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private Boolean isFinished;
    private LocalDate deliveryDate;

    @ManyToOne()
    @JoinColumn(name = "id_user")
    @JsonIgnore
    private User user;

    @ManyToMany(mappedBy="tasks", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Tag> tag = new ArrayList<>();


    public Task() {
    }

    public Task(String title, String description, Boolean isFinished, LocalDate deliveryDate) {
        this.title = title;
        this.description = description;
        this.isFinished = isFinished;
        this.deliveryDate = deliveryDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getFinished() {
        return isFinished;
    }

    public String getTitle() {
        return title;
    }

    public void setFinished(Boolean finished) {
        isFinished = finished;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Tag> getTag() {
        return tag;
    }

    public void setTag(List<Tag> tag) {
        this.tag = tag;
    }


    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", isFinished=" + isFinished +
                ", deliveryDate=" + deliveryDate +
                '}';
    }
}
