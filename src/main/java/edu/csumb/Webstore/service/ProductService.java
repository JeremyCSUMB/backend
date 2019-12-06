//The service file is where the heavy lifting is done.
//You will do all logic, all database access(Special database operations defined in the repository).
//Basically all your actual code is here!
package edu.csumb.Webstore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.csumb.Webstore.model.Product;
import edu.csumb.Webstore.repositories.ProductRepository;

//Remember to annotate what type of class this is!
@Service
public class ProductService
{
    @Autowired
    private ProductRepository repo;

    public Iterable<Product> getAll()
    {
        return repo.findAll();
    }

    public Product getById(String id) {
        return repo.findById(id).get();
    }

    public Product addProduct(Product myProduct) {
        return repo.save(myProduct);
    }
    public Boolean changeStock(String productId,Integer quantity){
        if(repo.existsById(productId)){
            Product product = repo.findById(productId).get();
            product.removeStock(quantity);
            repo.save(product);
            return true;
        }
        return false;
    }
}