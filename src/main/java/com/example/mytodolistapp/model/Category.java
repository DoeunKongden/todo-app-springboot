package com.example.mytodolistapp.model;

import java.time.LocalDateTime;

public class Category {
    private Long id;
    private String name;
    private LocalDateTime created_at;

    public Category() {
    }

    public Category(Long id, String name, LocalDateTime created_at) {
        this.id = id;
        this.name = name;
        this.created_at = created_at;
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

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", created_at=" + created_at +
                '}';
    }
}
