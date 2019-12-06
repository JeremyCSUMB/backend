//This is your model. This file should only contain getters and setters, along with the variables your struct uses.
//DONT FORGET THE CONSTRUCTOR! Getters and setters must be setup to match the name exactly
//or else you will have many errors.
package edu.csumb.Webstore.model;

import java.util.HashMap;

import org.springframework.data.annotation.Id;

public class User {
    @Id
    private String username;
    private String password;
    private HashMap<String, Integer> cart;
    public User() {
        username = "jeremy";
        password = "123";
        cart = new HashMap<String, Integer>();
    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        cart = new HashMap<String, Integer>();
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public HashMap<String, Integer> getCart() {
        return cart;
    }
    public void setCart(HashMap<String, Integer> cart) {
        this.cart = cart;
    }
    public void addToCart(String productId, Integer quantity) {
        if (cart.containsKey(productId)) {
            cart.put(productId, cart.get(productId) + quantity);
        } else {
            cart.put(productId, quantity);
        }
    }
    public void updateCart(String productId, Integer quantity) {
        if (cart.containsKey(productId)) {
            if (quantity < 1) {
                cart.remove(productId);
            } else {
                cart.replace(productId, quantity);
            }
        }
    }
    public void clearCart() {
        cart.clear();
    }
}