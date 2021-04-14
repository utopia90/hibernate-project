package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private TagColor tagColor;


    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinTable(
            name = "task_tag",
            joinColumns = {@JoinColumn(name="tag_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="task_id", referencedColumnName = "id")}
    )
    private List<Task> tasks = new ArrayList<>();

    public Tag() {
    }

    public Tag(String name, TagColor tagColor) {
        this.name = name;
        this.tagColor = tagColor;
    }

    public TagColor getTagColor() {
        return tagColor;
    }

    public void setTagColor(TagColor tagColor) {
        this.tagColor = tagColor;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
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



    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tagColor=" + tagColor +
                '}';
    }
}
