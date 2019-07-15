package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

public class ProductForm {

    private Long id;
    private String name;
    private float price;
    private String producer;
    private MultipartFile image;

    public ProductForm() {
    }


    public ProductForm(Long id, String name, float price, String producer, MultipartFile image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.producer = producer;
        this.image = image;
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



    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
