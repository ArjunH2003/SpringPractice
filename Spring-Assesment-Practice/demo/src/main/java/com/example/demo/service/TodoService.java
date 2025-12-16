package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Todo;
import com.example.demo.dao.TodoRepository;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public ResponseEntity<Todo> createTodo(Todo todo){

        if(todo!=null){

            todoRepository.save(todo);
            return ResponseEntity.ok().body(todo);

        }
        return ResponseEntity.noContent().build();
    }


    public ResponseEntity<Todo> getTodoById(Long id){

        Optional<Todo> op = todoRepository.findById(id);
        if(op.isEmpty()){

            throw new ResourceNotFoundException("Not found!");
        }
        Todo t = op.get();
        return ResponseEntity.ok().body(t);
    
    }

    public List<Todo> getAllTodos(){

        return todoRepository.findAll();
    }

    public ResponseEntity<Todo> updateTodo(Long id,Todo todo){

        Optional<Todo> op = todoRepository.findById(id);
        if(op.isEmpty()){
            throw new ResourceNotFoundException("Not found");
        }
        Todo existing = op.get();
        existing.setTitle(todo.getTitle());
        existing.setCompleted(todo.isCompleted());
        todoRepository.save(existing);
        return ResponseEntity.ok().body(existing);
    }

    public ResponseEntity<Todo> deleteTodo(Long id){
        
        Todo todo = todoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Found!"));
        todoRepository.delete(todo);
        return ResponseEntity.ok().body(todo);

    }

    public List<Todo> findByPrefix(String prefix){

        if(prefix==null){
            throw new ResourceNotFoundException("Not found");

        }
        return todoRepository.findByTitleStartingWithIgnoreCase(prefix);

    }


}













//     Todo createTodo(Todo todo);
//     Todo getTodoById(Long id);
//     List<Todo> getAllTodos();
//     Todo updateTodo(Long id, Todo todo);
//     void deleteTodo(Long id);
// }
