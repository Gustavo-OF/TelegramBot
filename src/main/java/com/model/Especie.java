package com.model;

import java.util.List;

public class Especie {
    public int id;
    public String name;
    public String description;
    public String createdAt;
    public String updatedAt;
    public List<Personagem> characters;

    public Especie(){

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
        return "Especie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", characters=" + characters +
                '}';
    }
}
