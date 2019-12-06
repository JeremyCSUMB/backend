package edu.csumb.Webstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import edu.csumb.Webstore.model.User;
import edu.csumb.Webstore.repositories.UserRepository;

@Component
public class UserSeeder implements CommandLineRunner {
    @Autowired
    private UserRepository repo;

    @Override
    public void run(String... args) {
        User user = new User();
        User user2 = new User("admin", "test");
        repo.deleteAll();
        repo.saveAll(Arrays.asList(user, user2));
    }
}