package com.springboot.web.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.web.model.Todo;

@Service
public class TodoService {
	@PersistenceContext
	EntityManager em;
    private static List<Todo> todos = new ArrayList<Todo>();
    private static int todoCount = 3;

    static {
        todos.add(new Todo(1, "Asreet", "Learn Spring MVC", new Date(),
                false));
        todos.add(new Todo(2, "Asreet", "Learn Struts", new Date(), false));
        todos.add(new Todo(3, "Asreet", "Learn Hibernate", new Date(),
                false));
    }

    public List<Todo> retrieveTodos(String user) {
        List<Todo> filteredTodos = new ArrayList<Todo>();
        for (Todo todo : todos) {
            if (todo.getUser().equalsIgnoreCase(user)) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }
    
    public Todo retrieveTodo(int id) {
        for (Todo todo : todos) {
            if (todo.getId()==id) {
                return todo;
            }
        }
        return null;
    }

    public void updateTodo(Todo todo){
    		todos.remove(todo);
    		todos.add(todo);
    }
@Transactional
    public void addTodo(String name, String desc, Date targetDate,
            boolean isDone) {
        //todos.add(new Todo(++todoCount, name, desc, targetDate, isDone));
    	Todo td= new Todo(++todoCount, name, desc, targetDate, isDone);
        em.persist(td);
        
    }

    public void deleteTodo(int id) {
        Iterator<Todo> iterator = todos.iterator();
        while (iterator.hasNext()) {
            Todo todo = iterator.next();
            if (todo.getId() == id) {
                iterator.remove();
            }
        }
    }
}