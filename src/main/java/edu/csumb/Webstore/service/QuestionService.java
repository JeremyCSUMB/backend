//The service file is where the heavy lifting is done.
//You will do all logic, all database access(Special database operations defined in the repository).
//Basically all your actual code is here!
package edu.csumb.Webstore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.csumb.Webstore.model.Question;
import edu.csumb.Webstore.repositories.QuestionRepository;

//Remember to annotate what type of class this is!
@Service
public class QuestionService
{
    @Autowired
    private QuestionRepository repo;

    public Iterable<Question> getAll()
    {
        return repo.findAll();
    }

    public Question getById(String id) {
        return repo.findById(id).get();
    }

    public Question addQuestion(Question myQuestion) {
        return repo.save(myQuestion);
    }

    public Boolean removeById(String id) {
        if (repo.existsById(id)) {
            repo.delete(repo.findById(id).get());
            return true;
        } else {
            return false;
        } 
    }
}