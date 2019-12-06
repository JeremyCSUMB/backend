//The service file is where the heavy lifting is done.
//You will do all logic, all database access(Special database operations defined in the repository).
//Basically all your actual code is here!
package edu.csumb.Webstore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.csumb.Webstore.model.User;
import edu.csumb.Webstore.repositories.UserRepository;

//Remember to annotate what type of class this is!
@Service
public class UserService
{
    @Autowired
    private UserRepository repo;

    @Autowired
    ProductService productService;

    public boolean authenticate(String username, String password) {
        if (repo.existsById(username.toLowerCase())) {
            return repo.findById(username).get().getPassword().equals(password);
        } else {
            return false;
        }
    }
    public boolean addUser(String username, String password) {
        if (repo.existsById(username.toLowerCase())) {
            return false;
        }
        repo.save(new User(username, password));
        return true;
    }

    public boolean addProduct(String username, String productId, Integer quantity) {
        if (quantity < 1) {
            return false;
        }
        if (repo.existsById(username.toLowerCase())) {
            User user = repo.findById(username).get();
            user.addToCart(productId, quantity);
            repo.save(user);
            return true;
        }
        return false;
    }
    public boolean updateProduct(String username, String productId, Integer quantity) {
        if (repo.existsById(username.toLowerCase())) {
            User user = repo.findById(username).get();
            user.updateCart(productId, quantity);
            repo.save(user);
            return true;
        }
        return false;
    }

    public Boolean checkoutProduct(String username) {
        if (repo.existsById(username.toLowerCase())) {
            User user = repo.findById(username).get();

            for (String productId : user.getCart().keySet()) {
                productService.changeStock(productId, user.getCart().get(productId));
            }
            user.clearCart();
            repo.save(user);
            return true;
        }
        return false;
    }
}