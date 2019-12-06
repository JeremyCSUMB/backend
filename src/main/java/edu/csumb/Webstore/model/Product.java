//This is your model. This file should only contain getters and setters, along with the variables your struct uses.
//DONT FORGET THE CONSTRUCTOR! Getters and setters must be setup to match the name exactly
//or else you will have many errors.
package edu.csumb.Webstore.model;

import org.springframework.data.annotation.Id;

public class Product
{
    String name;
    @Id
    String id;
    String description;
    String imageURL;
    Double price;
    Integer stock;

    public Product() {
        name = "Default";
        description = "This is the description of a default product";
        imageURL = "null";
        price = 420.0;
        stock = 69;
    }
    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
    public String getDescription() {
        return description;
    }
    public String getImageUrl() {
        return imageURL;
    }
    public Double getPrice() {
        return price;
    }
    public Integer getStock() {
        return stock;
    }
    public void removeStock(Integer quantity) {
        this.stock -= quantity;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setImageUrl(String imageURL) {
        this.imageURL = imageURL;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public void setStock(Integer stock) {
        this.stock = stock;
    }
}