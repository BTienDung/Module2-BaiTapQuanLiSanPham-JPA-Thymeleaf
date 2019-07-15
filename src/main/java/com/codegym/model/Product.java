package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    private Long id;
    private String name;
    private float price;
    private String producer;
    private String avatar;

    public Product() {
    }

    public Product(Long id, String name, float price, String producer, String avatar) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.producer = producer;
        this.avatar = avatar;
    }
    public Product(Long id, String name, float price, String producer, MultipartFile image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.producer = producer;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}
