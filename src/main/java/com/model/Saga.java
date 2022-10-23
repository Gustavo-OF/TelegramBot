package com.model;

import java.util.List;

public class Saga {

    private int id;
    private String name;
    private String description;
    private String image;
    private String createdAt;
    private String updatedAt;
    private List<Personagem> characters;

    public Saga(){

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Personagem> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Personagem> characters) {
        this.characters = characters;
    }

    @Override
    public String toString() {
        return "Saga{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", characters=" + characters.toString() +
                '}';
    }
}
