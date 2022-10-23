package com.model;

import java.util.List;

public class Planeta {
    private int id;
    private String name;
    private String image;
    private String createdAt;
    private String updatedAt;
    private List<Personagem> characters;

    public Planeta(){

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
        return "Planeta{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", characters=" + characters +
                '}';
    }


}
