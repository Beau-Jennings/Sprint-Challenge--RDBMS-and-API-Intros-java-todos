package com.lambdaschool.todos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "todos")
public class Todos
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long todoid;

    @Column(nullable = false)
    private String description;
    
    private boolean completed = false;
    
    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties(value = "todos", allowSetters = true)
    private User user;

    public Todos()
    {
    }

    public Todos(String description, boolean completed, User user)
    {
        this.description = description;
        this.completed = completed;
        this.user = user;
    }

    public long getTodosid()
    {
        return todoid;
    }

    public void setTodosid(long todoid)
    {
        this.todoid = todoid;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public boolean isCompleted()
    {
        return completed;
    }

    public void setCompleted(boolean completed)
    {
        this.completed = completed;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
}
