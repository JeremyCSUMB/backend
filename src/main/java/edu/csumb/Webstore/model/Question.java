//This is your model. This file should only contain getters and setters, along with the variables your struct uses.
//DONT FORGET THE CONSTRUCTOR! Getters and setters must be setup to match the name exactly
//or else you will have many errors.
package edu.csumb.Webstore.model;

import org.springframework.data.annotation.Id;

public class Question
{
    String question;
    @Id
    String id;
    String description;
    Integer value;
    String a;
    String b;
    String c;
    String answer;

    public Question() {
        question = "Default";
        description = "This is the description of a default question";
        a = "a";
        b = "b";
        c = "c";
        answer = a;
        value = 1;
    }
    public String getQuestion() {
        return question;
    }
    public String getId() {
        return id;
    }
    public String getDescription() {
        return description;
    }
    public String getA() {
        return a;
    }
    public String getB() {
        return b;
    }
    public String getC() {
        return c;
    }
    public String getAnswer() {
        return answer;
    }
    public Integer getValue() {
        return value;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setA(String a) {
        this.a = a;
    }
    public void setB(String b) {
        this.b = b;
    }
    public void setC(String c) {
        this.c = c;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public void setValue(Integer value) {
        this.value = value;
    }
}