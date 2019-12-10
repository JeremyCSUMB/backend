package edu.csumb.Webstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import edu.csumb.Webstore.model.Admin;
import edu.csumb.Webstore.repositories.AdminRepository;

@Component
public class UserSeeder implements CommandLineRunner {
    @Autowired
    private AdminRepository repo;

    @Override
    public void run(String... args) {
        Admin admin = new Admin();
        repo.deleteAll();
        repo.saveAll(Arrays.asList(admin));
    }
}