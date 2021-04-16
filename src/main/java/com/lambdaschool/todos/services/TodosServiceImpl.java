package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;

public class TodosServiceImpl implements TodosService
{
    @Autowired
    private TodosRepository todosRepository;

    @Override
    public void markComplete(long todoid)
    {
        Todos todo = todosRepository.findById(todoid)
                .orElseThrow(() -> new EntityNotFoundException("Todo " + todoid + " not found"));

        todo.setCompleted(true);
        todosRepository.save(todo);
    }
}
