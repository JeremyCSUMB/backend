//The service file is where the heavy lifting is done.
//You will do all logic, all database access(Special database operations defined in the repository).
//Basically all your actual code is here!
package edu.csumb.Webstore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.csumb.Webstore.model.Admin;
import edu.csumb.Webstore.repositories.AdminRepository;

//Remember to annotate what type of class this is!
@Service
public class AdminService
{
    @Autowired
    private AdminRepository repo;

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
        repo.save(new Admin(username, password));
        return true;
    }

    public Iterable<Admin> getAll()
    {
        return repo.findAll();
    }

    public void removeAll() {
        repo.deleteAll();
    }
}